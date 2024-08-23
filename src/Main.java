import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello, how are you doing?");

        JLabel label1 = new JLabel("Name:");
        label1.setBounds(50, 50, 150, 50);

        JLabel label2 = new JLabel("Hello");
        label2.setBounds(50, 120, 100, 20);


        JTextField textField = new JTextField();
        textField.setBounds(150, 60, 150, 30);
        JButton button = new JButton("Submit");
        button.setBounds(150, 150, 100, 30);

        frame.add(label1);
        frame.add(label2);
        frame.add(textField);
        frame.add(button);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
