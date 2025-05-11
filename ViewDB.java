import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import javax.sql.rowset.*;
import javax.swing.*;

/**
 * This program uses metadata to display arbitrary tables in a database.
 * @version 1.33 2016-04-27
 * @author Cay Horstmann
 */
public class ViewDB {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ViewDBFrame();
            frame.setTitle("Sameer ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The frame that holds the data panel and the navigation buttons.
 */
class ViewDBFrame extends JFrame {
    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;
    private DataPanel dataPanel;
    private Component scrollPane;
    private JComboBox<String> tableNames;
    private Properties props;
    private CachedRowSet crs;
    private Connection conn;

    public ViewDBFrame() {
        tableNames = new JComboBox<String>();

        try {
            readDatabaseProperties();
            conn = getConnection();
            DatabaseMetaData meta = conn.getMetaData();
            try (ResultSet mrs = meta.getTables(null, null, null, new String[]{"TABLE"})) {
                while (mrs.next())
                    tableNames.addItem(mrs.getString(3));
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        tableNames.addActionListener(event -> showTable((String) tableNames.getSelectedItem(), conn));
        add(tableNames, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(event -> showPreviousRow());
        buttonPanel.add(previousButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(event -> showNextRow());
        buttonPanel.add(nextButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> deleteRow());
        buttonPanel.add(deleteButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(event -> saveChanges());
        buttonPanel.add(saveButton);

        if (tableNames.getItemCount() > 0)
            showTable(tableNames.getItemAt(0), conn);
    }

    public void showTable(String tableName, Connection conn) {
        try (Statement stat = conn.createStatement();
             ResultSet result = stat.executeQuery("SELECT * FROM " + tableName)) {

            RowSetFactory factory = RowSetProvider.newFactory();
            crs = factory.createCachedRowSet();
            crs.setTableName(tableName);
            crs.populate(result);

            if (scrollPane != null) remove(scrollPane);
            dataPanel = new DataPanel(crs);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane, BorderLayout.CENTER);
            pack();
            showNextRow();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void showPreviousRow() {
        try {
            if (crs == null || crs.isFirst()) return;
            crs.previous();
            dataPanel.showRow(crs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void showNextRow() {
        try {
            if (crs == null || crs.isLast()) return;
            crs.next();
            dataPanel.showRow(crs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Deletes current table row.
  