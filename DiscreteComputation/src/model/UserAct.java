package model;

public class UserAct {
    private ActionType type;
    private Task task;
    public UserAct(ActionType type, Task task){
        this.type = type;
        this.task = task;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public void undoAction(){

    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
