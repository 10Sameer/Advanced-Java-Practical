import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

class DataPanel extends JPanel {
    private List<JTextField> fields;

    public DataPanel(ResultSet rs) throws SQLException {
        fields = new ArrayList<>();
        setLayout(new GridLayout(0, 2));
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            add(new JLabel(rsmd.getColumnLabel(i)));
            JTextField field = new JTextField(20);
            fields.add(field);
            add(field);
        }
    }

   