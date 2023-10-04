package model;

import java.util.Calendar;

public class Task {
    private int identifier;
    private String title;
    private String description;
    private Calendar deadline;
    private Boolean isReminder;

    private int priority;
    public Task(String title, String description, Calendar deadline, Boolean isReminder,int priority){
        this.title=title;
        this.description=description;
        this.deadline=deadline;
        this.isReminder=isReminder;
        this.priority=priority;

    }
}
