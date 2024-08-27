import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DHIREN {
    public DHIREN() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel l1 = new JLabel("First Name:");
        l1.setBounds(50, 20, 100, 20);
        frame.add(l1);
        
        JTextField f1 = new JTextField();
        f1.setBounds(200, 20, 100, 20);
        frame.add(f1);
        
        JLabel l2 = new JLabel("Second Name:");
        l2.setBounds(50, 50, 100, 20);
        frame.add(l2);
        
        JTextField f2 = new JTextField();
        f2.setBounds(200, 50, 100, 20);
        frame.add(f2);
        
        JLabel l3 = new JLabel("Province:");
        l3.setBounds(50, 80, 100, 20);
        frame.add(l3);
        
        String[] provinceArray = {"Select province", "Koshi", "Karnali", "Madhesh", "Kathmandu", "Humla", "Jumla"};
        
        JComboBox<String> b2 = new JComboBox<>(provinceArray);
        b2.setBounds(200, 80, 150, 30);
        frame.add(b2);
        
        JButton b1 = new JButton("Submit");
        b1.setBounds(100, 120, 100, 30);
        frame.add(b1);

        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = f1.getText();
                String lname = f2.getText();
                try {
                    // Load MySQL JDBC driver if needed
                    // Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    // Connect to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bimii", "root", "");
                    System.out.println("Connected Successfully");
                    
                    String sql = "INSERT INTO user1 (FIRSTNAME, LASTNAME) VALUES (?, ?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, fname);
                    pst.setString(2, lname);
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(frame, "Data Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Data Inserted Successfully");
                    
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("SQL Exception: " + ex.getMessage());
                }
            }
        });
    }


    // main function to start the program
    public static void main(String[] args) {
        new DHIREN();
    }
}
