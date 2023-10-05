package model;

import util.HashTableChaining;

import javax.swing.*;
import java.util.Stack;

public class MyController implements Cloneable {
    private HashTableChaining<Integer,Task> hashTableChaining;
    private Stack<MyController> versionController;
    public MyController() {
        this.hashTableChaining=new HashTableChaining<Integer,Task>();
        this.versionController = new Stack<>();

    }
    public void addTask(String title,String description,String deadline,boolean isReminder,int priority){
        Task taskToHash=new Task(title,description,deadline,isReminder,priority);
        hashTableChaining.insert(taskToHash.getIdentifier(),taskToHash);
        ImageIcon ImageIcon;
        JOptionPane.showConfirmDialog(null,"Task:  "+taskToHash.getTitle()+"with key "+ taskToHash.getIdentifier()+" was added ","Confirmation",JOptionPane.OK_OPTION,JOptionPane.OK_OPTION,ImageIcon =new ImageIcon("src/view/img_7.png"));
    }
    public void modifyTask(int key,int attribute,String value){

        String oldvalue="";
       Task taskToModify= hashTableChaining.search(key);
       if (taskToModify==null){
           JOptionPane.showMessageDialog(null,"Couldn't find the task associated to that ID");
       }else {


           switch (attribute) {
               case 0:
                   oldvalue += taskToModify.getTitle();
                   taskToModify.setTitle(value);
                   break;
               case 1:
                   oldvalue += taskToModify.getDescription();
                   taskToModify.setDescription(value);
                   break;
               case 2:
                   oldvalue += taskToModify.getDeadline();
                   taskToModify.setDeadline(value);
                   break;
           }
       JOptionPane.showMessageDialog(null, "El atributo con valor: " + oldvalue + " ahora es :" + value);
       }

    }

    @Override
    public void saveState() {

    }

    @Override
    public void restoreState() {

    }
    public static void main(String[] args){
        MyController controller=new MyController();
        Task newTask=new Task("a","b","b",true,4);
        HashTableChaining<Integer,Task> hashTableChaining1=new HashTableChaining<>();
        hashTableChaining1.insert(newTask.getIdentifier(),newTask);
       Task found = hashTableChaining1.search(newTask.getIdentifier());

       System.out.println(hashTableChaining1.toString());

    }
}
