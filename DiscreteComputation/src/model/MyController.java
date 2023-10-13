package model;

import util.HashTableChaining;
import util.MaxHeap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class MyController{
    private HashTableChaining<Integer,Task> hashTableChaining;
    private MaxHeap<Task> maxHeap;
    private Stack<UserAct> ver;
    private MaxHeap<Task> priorityTasksQueue;
    private ArrayList<Task> noPriority;
    public MyController() {
        hashTableChaining=new HashTableChaining<Integer,Task>();
        maxHeap = new MaxHeap<>();
        ver = new Stack<>();
        priorityTasksQueue=new MaxHeap<>();
        noPriority=new ArrayList<>();
    }
    public void addTask(String title,String description,String deadline,boolean isReminder,int priority){
        Task taskToHash = new Task(title,description,deadline,isReminder,priority);
        hashTableChaining.insert(taskToHash.getIdentifier(),taskToHash);
        ver.push(new UserAct(ActionType.ADDTASK, taskToHash));
        ImageIcon ImageIcon;
        JOptionPane.showConfirmDialog(null,"Task:  "+taskToHash.getTitle()+"with key "+ taskToHash.getIdentifier()+" was added ","Confirmation",JOptionPane.OK_OPTION,JOptionPane.OK_OPTION,ImageIcon =new ImageIcon("DiscreteComputation/src/view/img_7.png"));
        if (taskToHash.getPriority()!=0){
            priorityTasksQueue.insert(taskToHash.getPriority(), taskToHash);
        } else{
            noPriority.add(taskToHash);
        }
    }
    public void modifyTask(int key,int attribute,String value){
        String oldvalue="";
        Task CopyTask = null;
        CopyTask.TaskCons(hashTableChaining.search(key));
       Task taskToModify = hashTableChaining.search(key);

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
               case 3:
                   oldvalue += taskToModify.getPriority() ;
                   taskToModify.setPriority(Integer.parseInt(value));
                   priorityTasksQueue.increaseKey(taskToModify.getPriority(), taskToModify);
           }
       JOptionPane.showMessageDialog(null, "The attribute with value : " + oldvalue + " is now :" + value);
       }
    }
    public boolean deleteTask(int key){
        Task taskToDelete=hashTableChaining.search(key);
        if(taskToDelete==null){
            JOptionPane.showMessageDialog(null,"Couldn't find the task associated to that ID");
            return false;
        }
        else{
            hashTableChaining.delete(key);
            JOptionPane.showMessageDialog(null,"Task: "+ taskToDelete.getTitle()+" was deleted successfully");
            return true;
        }
    }
    public void undone(){
        UserAct action = ver.pop();
        switch (action.getType()){
            case ADDTASK:
                deleteTask(action.getTask().getIdentifier());
                break;
            case DELETETASK:
                addTask(action.getTask().getTitle(), action.getTask().getDescription(), action.getTask().getDeadline(), action.getTask().getReminder(), action.getTask().getPriority());
                break;
            case MODIFYTASK:
        }
    }
    public static void main(String[] args){
        MyController controller=new MyController();
        Task newTask=new Task("a","b","b",true,4);
        HashTableChaining<Integer,Task> hashTableChaining1=new HashTableChaining<>();
        hashTableChaining1.insert(newTask.getIdentifier(),newTask);
        Task found = hashTableChaining1.search(newTask.getIdentifier());
        hashTableChaining1.delete(found.getIdentifier());
        System.out.println(hashTableChaining1.toString());
    }
}
