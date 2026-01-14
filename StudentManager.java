import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentManager extends JFrame {

    JTextField idField, nameField, classField, attendanceField;
    JTable table;
    DefaultTableModel model;

    public StudentManager() {
        setTitle("Student Management System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== Main Layout =====
        setLayout(new BorderLayout(10, 10));

        // ===== Form Panel =====
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        idField = new JTextField();
        nameField = new JTextField();
        classField = new JTextField();
        attendanceField = new JTextField();

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Class:"));
        formPanel.add(classField);
        formPanel.add(new JLabel("Attendance:"));
        formPanel.add(attendanceField);

        // ===== Button Panel =====
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Student");
        JButton deleteBtn = new JButton("Delete Student");

        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);

        // ===== Table =====
        model = new DefaultTableModel(new String[]{"ID", "Name", "Class", "Attendance"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));

        // ===== Add to Frame =====
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // ===== Button Actions =====
        addBtn.addActionListener(e -> addStudent());
        deleteBtn.addActionListener(e -> deleteStudent());

        setVisible(true);
    }

    void addStudent() {
        model.addRow(new Object[]{
                idField.getText(),
                nameField.getText(),
                classField.getText(),
                attendanceField.getText()
        });

        idField.setText("");
        nameField.setText("");
        classField.setText("");
        attendanceField.setText("");
    }

    void deleteStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student first!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManager());
    }
}
