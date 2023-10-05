package ui;

import model.MyController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyScreen extends JFrame{
    private JLabel cat;
    private JLabel toModify;
    private JPanel modify;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JButton modifyButton;
    private JButton cancelButton;
    private JTextField textField2;

    public ModifyScreen(MyController controller) {
        setContentPane(modify);
        setTitle("Task Modification");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(false);

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key=Integer.parseInt(textField1.getText());
                int attribute=comboBox2.getSelectedIndex();
                String value=textField2.getText();
                controller.modifyTask(key,attribute,value);
                setVisible(false);
            }
        });
    }
}
