import javax.swing.*;
import java.awt.*;

public class TeacherPanel extends JFrame {
    public TeacherPanel() {
        setTitle("Teacher Panel - Student Management System");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel label = new JLabel("Teacher Controls", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addBtn = new JButton("Add Student");
        JButton removeBtn = new JButton("Remove Student");
        JButton updateBtn = new JButton("Update Student");
        JButton assignBtn = new JButton("Put Assignment");
        JButton attendanceBtn = new JButton("Manage Attendance");

        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(assignBtn);
        buttonPanel.add(attendanceBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // ✅ Modify only this part:
        // Action for Add Student button
        addBtn.addActionListener(e -> {
            new AddStudent(); // opens the AddStudent form
           dispose();
        });

        // You can keep others as placeholders for now
        removeBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Remove Student - Coming Soon"));
        updateBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Update Student - Coming Soon"));
        assignBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Put Assignment - Coming Soon"));
        attendanceBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Manage Attendance - Coming Soon"));

        setVisible(true);
    }
}
