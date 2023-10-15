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
    private DeleteScreen deleteScreen;


    public MainScreenUI(MyController controller){
        this.controller=controller;
        this.taskCreationScreen=new TaskCreationScreen(controller);
        this.modifyScreen=new ModifyScreen(controller);
        this.deleteScreen=new DeleteScreen(controller);
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
                        taskCreationScreen.setVisible(true);
                        break;
                    case 1:
                        modifyScreen.setVisible(true);
                        break;
                    case 2:
                        deleteScreen.setVisible(true);
                        break;
                    case 3:
                      JOptionPane.showConfirmDialog(null,controller.showNoPriorityTasks());
                      break;
                    case 4:
                        JOptionPane.showConfirmDialog(null,controller.showPriorityTasks());
                        break;
                }

            }
        });
        UndoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.undone();
                JOptionPane.showMessageDialog(null,"Last action was undone.");
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bye byeeeeee ^^ <3");
                System.exit(0);
            }
        });
    }
    public static void main(String[] args){

        new MainScreenUI(new MyController());
    }

}
