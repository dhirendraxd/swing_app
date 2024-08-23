import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("hello hwo you doing ");
        JLabel label1 = new JLabel("hello");
        label1.setBounds(50,50,100,20);
        JLabel label2 = new JLabel("hello");
        label2.setBounds(50,50,100,20);
        System.out.println("Hello world!");

        frame.add(label1);
        frame.add(label2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);


    }

}