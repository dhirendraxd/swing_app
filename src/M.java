// package swing;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author dhiren
 */
public class M {
    public M(){
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
        f2.setBounds(200, 40, 100, 20);
        frame.add(f2);

        JButton btn = new JButton("Submit");
        btn.setBounds(100, 60, 100, 20);
        frame.add(btn);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = f1.getText();
                String secondName = f2.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                DriverManager.getConnection("jdbc:mysql://localhost/form","root");
                System.out.println("connnected sucessfully");
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());

                }
            }
        });
    }

    public static void main(String[] args) {
        new M();
    }
}
