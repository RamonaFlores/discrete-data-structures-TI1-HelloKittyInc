package ui;

import model.MyController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenUI extends JFrame {

    private JPanel MainPanel;
    private JLabel Bear;
    private JLabel Logo;
    private JLabel ghibli;
    private JButton UndoButton;
    private JButton ExitButton;
    private JComboBox comboBox1;
    private JLabel message;

    private MyController controller;
    private TaskCreationScreen taskCreationScreen;
    private ModifyScreen modifyScreen;


    public MainScreenUI(MyController controller){
        this.controller=controller;
        this.taskCreationScreen=new TaskCreationScreen(controller);
        this.modifyScreen=new ModifyScreen(controller);
        setContentPane(MainPanel);
        setTitle("Remind");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(590,630);
        setLocationRelativeTo(null);
        setVisible(true);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option=comboBox1.getSelectedIndex();
                switch(option){
                    case 0:
                        JOptionPane.showMessageDialog(null,"boff");
                        taskCreationScreen.setVisible(true);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,"raul mamabi");
                     modifyScreen.setVisible(true);

                }
            }
        });
    }
    public static void main(String[] args){

        new MainScreenUI(new MyController());
    }

}
