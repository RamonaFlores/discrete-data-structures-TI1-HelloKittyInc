package model;

import java.util.Calendar;

public class Task implements Comparable<Task> {

    private String title;
    private String description;
    private String deadline;
    private Boolean isReminder;
    private int priority;
    static private int identifier;
    public Task(String title, String description, String   deadline, Boolean isReminder, int priority){
        this.title=title;
        this.description=description;
        this.deadline=deadline;
        this.isReminder=isReminder;
        this.priority=priority;
        this.identifier++;

    }
    public int generateIdentifier(){
        return title.hashCode();
    }

    public int getIdentifier() {
        return identifier;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Boolean getReminder() {
        return isReminder;
    }

    public void setReminder(Boolean reminder) {
        isReminder = reminder;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", isReminder=" + isReminder +
                ", priority=" + priority +
                '}';
    }
    @Override
    public int compareTo(Task o) {
        if(this.priority < o.getPriority()){
            return -1;
        } else if (this.priority > o.getPriority()){
            return 1;
        } else {
            return 0;
        }
    }
}
