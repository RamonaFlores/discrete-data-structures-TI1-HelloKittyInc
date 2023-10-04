package ui;

import model.MyController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskCreationScreen extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JLabel DescriptionLabel;
    private JLabel TitleLabel;
    private JRadioButton taskRadioButton;
    private JRadioButton reminderRadioButton;
    private JLabel TypeLabel;
    private JTextField priorityNDeadline2;
    private JComboBox priorityBox1;
    private JLabel priorityLabel;
    private JButton ConfirmButton;
    private JButton cancelButton;
    MyController controller;

    public TaskCreationScreen(MyController controller){
    setContentPane(panel1);
    setTitle("Task Creation");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(590,630);
    ButtonGroup group=new ButtonGroup();
    group.add(taskRadioButton);
    group.add(reminderRadioButton);
    reminderRadioButton.setActionCommand("reminder");
    taskRadioButton.setActionCommand("task");
    setLocationRelativeTo(null);
    setVisible(false);



        ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTaskbool;
                String taskTitle= textField1.getText();
                String taskDescription=textField1.getText();
                String deadline=priorityNDeadline2.getText();
                String isTask= reminderRadioButton.getActionCommand();
                if(isTask.equals("task")){
                    isTaskbool=false;
                }else{isTaskbool=true;}
                int priority=priorityBox1.getSelectedIndex();
                controller.addTask(taskTitle,taskDescription,deadline,isTaskbool,priority);
                setVisible(false);
            }
        });
    }
}
