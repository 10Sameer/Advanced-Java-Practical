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

    public void showRow(ResultSet rs) {
        try {
            if (rs == null) return;
            for (int i = 0; i < fields.size(); i++) {
                fields.get(i).setText(rs.getString(i + 1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setRow(ResultSet rs) throws SQLException {
        for (int i = 0; i < fields.size(); i++) {
            rs.updateString(i + 1, fields.get(i).getText());
        }
        rs.updateRow();
    }
}
