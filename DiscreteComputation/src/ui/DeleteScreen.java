package ui;

import model.MyController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteScreen extends JFrame{
    private JTextField ans;
    private JLabel image;
    private JLabel textField;
    private JButton removeButton;
    private JPanel delete;

    public DeleteScreen(MyController controller){
        setContentPane(delete);
        setTitle("Task delete");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idstr=ans.getText();
                int identifier=Integer.parseInt(idstr);
                controller.deleteTask(identifier);

                setVisible(false);

            }
        });
    }

}
