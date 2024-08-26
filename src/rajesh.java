import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    public class rajesh {
        public rajesh(){
            JFrame frame = new JFrame();
            frame.setSize(500, 500);
            JLabel l1 = new JLabel("First Name:");
            l1.setBounds(50, 20, 100, 20);
            frame.add(l1);
            JTextField f1 = new JTextField();
            f1.setBounds(200, 20, 100, 20);
            frame.add(f1);
            JLabel l2 = new JLabel("Second Name:");
            l2.setBounds(50, 40, 100, 20);
            frame.add(l2);
            JTextField f2 = new JTextField();
            f2.setBounds(200, 40, 100,20);
            frame.add(f2);
            JLabel l3 = new JLabel("Province");
            l3.setBounds(50, 40, 100, 20);
            frame.add(l3);
            String[] provinceArray = {"Select province","Koshi","Karnali","Madhesh","Kathmandu","Humla","Jumla"};
            JComboBox b2 = new JComboBox(provinceArray);
            b2.setBounds(100,100,100,40);
            frame.add(b2);
            JButton b1 = new JButton("Submit");
            b1.setBounds(100, 60, 100, 20);
            frame.add(b1);

            frame.setLayout(null);
            frame.setVisible(true);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fname = f1.getText();
                    String lname = f2.getText();
                    try {
                        // Load MySQL JDBC driver
                       // Class.forName("com.mysql.cj.jdbc.Driver");
                        // Connect to the database
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bimii", "root", "");
                        System.out.println("Connected Successfully");
                        String sql ="Insert into user1 (FIRSTNAME,LASTNAME) values (?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, fname);
                        pst.setString(2, lname);
                        pst.execute();
                        System.out.println("CData Inserted Successfully");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        System.out.println("SQL Exception: " + ex.getMessage());
                    }
                }
            });
        }
        public static void main(String[] args) {
            new rajesh();
        }
    }