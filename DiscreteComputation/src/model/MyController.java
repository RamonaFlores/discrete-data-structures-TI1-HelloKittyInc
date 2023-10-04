package model;

import util.HashTableChaining;

import java.util.Stack;

public class MyController implements Cloneable {
    private HashTableChaining hashTableChaining;
    private Stack<MyController> versionController;
    public MyController() {
        this.hashTableChaining=new HashTableChaining<>();
        this.versionController = new Stack<>();

    }
    public void addTask(String title,String description,String deadline,boolean isReminder,int priority){

    }

    @Override
    public void saveState() {

    }

    @Override
    public void restoreState() {

    }
}
