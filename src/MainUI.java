import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    public MainUI() {
        setTitle("Student Management System");
        setSize(800, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Student Management System", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        JButton teacherBtn = new JButton("Teacher Panel");
        JButton studentBtn = new JButton("Student Panel");

        teacherBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        studentBtn.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 20, 10));
        buttonPanel.add(teacherBtn);
        buttonPanel.add(studentBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // Action for Teacher Panel button
        teacherBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TeacherPanel();  // opens teacher panel
                dispose(); // close main menu
            }
        });

        // Student panel (we'll implement later)
        studentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Student Panel coming soon!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
