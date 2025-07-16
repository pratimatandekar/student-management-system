import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent extends JFrame {
    private JTextField nameField, emailField, phoneField, courseField;

    public AddStudent() {
        setTitle("Add Student");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Form Fields
        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        add(courseField);

        // Buttons
        JButton submitBtn = new JButton("Add Student");
        JButton clearBtn = new JButton("Clear");

        add(submitBtn);
        add(clearBtn);

        // Action: Add to database
        submitBtn.addActionListener(e -> addStudentToDatabase());

        // Action: Clear form
        clearBtn.addActionListener(e -> clearForm());

        setVisible(true);
    }

    private void addStudentToDatabase() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String course = courseField.getText();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = Conn.getConnection()) {
            String sql = "INSERT INTO students (name, email, phone, course) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, course);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Student added successfully!");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add student.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        courseField.setText("");
    }
}
