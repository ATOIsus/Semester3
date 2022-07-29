package programmingForDevelopers.z_GUI.Face;


import programmingForDevelopers.z_GUI.Brain.Brain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Face extends JFrame implements ActionListener {

    JButton buttonChangeFkingName;
    JButton buttonChangeFkingName1;
    JTextField textChangeFkingName2;
    JTextField textChangeFkingName3;
    JLabel labelChangeFkingName4;
    JLabel labelChangeFkingName5;

    Face() {

        setLayout(null);
        setSize(500, 500);
        setResizable(false);
        setTitle("Math");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelChangeFkingName4 = new JLabel("First Number ");
        labelChangeFkingName4.setBounds(20, 20, 100, 20);
        add(labelChangeFkingName4);

        textChangeFkingName2 = new JTextField();
        textChangeFkingName2.setBounds(150, 20, 100, 20);
        add(textChangeFkingName2);


        labelChangeFkingName5 = new JLabel("Second Number");
        labelChangeFkingName5.setBounds(20, 50, 100, 20);
        add(labelChangeFkingName5);

        textChangeFkingName3 = new JTextField();
        textChangeFkingName3.setBounds(150, 50, 100, 20);
        add(textChangeFkingName3);


        buttonChangeFkingName = new JButton("Sum");
        buttonChangeFkingName.setBounds(50, 100, 80, 20);
        add(buttonChangeFkingName);
        buttonChangeFkingName.addActionListener(this);

        buttonChangeFkingName1 = new JButton("Exit");
        buttonChangeFkingName1.setBounds(150, 100, 80, 20);
        add(buttonChangeFkingName1);
        buttonChangeFkingName1.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int a = Integer.parseInt(textChangeFkingName2.getText());
        int b = Integer.parseInt(textChangeFkingName3.getText());

        if (e.getSource().equals(buttonChangeFkingName)) {
            Brain obb = new Brain(a, b);

            JOptionPane.showMessageDialog(null, "Sum: " + obb.add());
        }

        if (e.getSource().equals(buttonChangeFkingName1)) {
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        new Face().setVisible(true);
    }
}