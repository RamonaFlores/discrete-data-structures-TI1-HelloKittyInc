package test;

import model.ActionType;
import model.Task;
import model.UserAct;
import org.junit.jupiter.api.Test;
import util.NodeST;
import util.Stack;

import static org.junit.jupiter.api.Assertions.assertSame;

public class UndoTest {
    Stack<UserAct> stack = new Stack<>();
    /**
     *
     * in this case 3 objects of type action user are added and the last one
     * is removed and compared if
     * it is the same with the last one removed from the stack.
     *
     */
    @Test
    public void testStackPop(){
        Task task1 = new Task("TASK1", "...", "17/10/2023", true, 3);

        UserAct userAct1 = new UserAct(ActionType.ADDTASK, task1);
        UserAct userAct2 = new UserAct(ActionType.MODIFYTASK, task1);
        UserAct userAct3 = new UserAct(ActionType.DELETETASK, task1);

        stack.push(userAct1);
        stack.push(userAct2);
        stack.push(userAct3);

        assertSame(userAct3, stack.pop());

    }
    /**
     *
     * in this case, 3 objects of type action user are
     * added and the last one is removed and compared
     * if it is the same as the last one added.
     *
     */
    @Test
    public void testStackTop(){
        Task task1 = new Task("TASK1", "...", "17/10/2023", true, 3);

        UserAct userAct1 = new UserAct(ActionType.ADDTASK, task1);
        UserAct userAct2 = new UserAct(ActionType.MODIFYTASK, task1);
        UserAct userAct3 = new UserAct(ActionType.DELETETASK, task1);

        stack.push(userAct1);
        stack.push(userAct2);
        stack.push(userAct3);

        assertSame(userAct3, stack.top());
    }

}
