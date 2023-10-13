package test;
import model.Task;
import org.junit.jupiter.api.*;
import util.MaxHeap;

public class MaxHeapTest {
    MaxHeap<Task> taskMaxHeap = new MaxHeap<>();
    /**
     * Tests whether the MaxHeap correctly returns the maximum priority value.
     * In this case many task are created with different priorities, many task with priority 4, and then are added
     * to priority queue and check if the most priority "4" is the maxPriority in the heap.
     */
    @Test
    public void testHeapMaxValue() {

        // Create sample tasks with different priority values.
        Task task3 = new Task("TASK1", "...", "15/10/2023", true, 2);
        Task task4 = new Task("TASK2", "...", "16/10/2023", true, 4);
        Task task5 = new Task("TASK3", "...", "16/10/2023", true, 1);
        Task task1 = new Task("TASK4", "...", "17/10/2023", true, 4);
        Task task2 = new Task("TASK5", "..", "18/10/2023", true, 3);

        // Insert the tasks into the MaxHeap.
        taskMaxHeap.insert(task5.getPriority(), task5);
        taskMaxHeap.insert(task2.getPriority(), task2);
        taskMaxHeap.insert(task4.getPriority(),task4);
        taskMaxHeap.insert(task3.getPriority(), task3);
        taskMaxHeap.insert(task1.getPriority(), task1);
        taskMaxHeap.insert(task2.getPriority(), task2);
        taskMaxHeap.insert(task4.getPriority(), task4);

        // Extract the task with the maximum priority and check if its priority is as expected.
        Assertions.assertEquals(4,taskMaxHeap.maximum().getPriority());
        System.out.println(taskMaxHeap.printArray());
    }
    @Test
    public void testHeapExtracMax(){

        Task task1 = new Task("TASK1","...","22/09/23",true,2);
        Task task3 = new Task("TASK5","...","19/10/23",true,3);
        Task task4 = new Task("TASK3","...","24/10/23",true,1);
        Task task5 = new Task("TASK4","...","18/10/23",true,4);

        taskMaxHeap.insert(task5.getPriority(), task5);
        taskMaxHeap.insert(task4.getPriority(),task4);
        taskMaxHeap.insert(task3.getPriority(), task3);
        taskMaxHeap.insert(task1.getPriority(), task1);
        taskMaxHeap.insert(task4.getPriority(), task4);

        System.out.println(taskMaxHeap.printArray());
        Assertions.assertEquals(4, taskMaxHeap.maximum().getPriority());
        System.out.println();

        Assertions.assertEquals(4,taskMaxHeap.extractMax().getPriority());
        System.out.println(taskMaxHeap.printArray());

        Assertions.assertEquals(3,taskMaxHeap.maximum().getPriority());
    }
    @Test
    public void testHeapIncreaseKey(){

        Task task1 = new Task("TASK1","...","22/09/23",true,2);
        Task task3 = new Task("TASK5","...","19/10/23",true,3);
        Task task4 = new Task("TASK3","...","24/10/23",true,1);

        taskMaxHeap.insert(task4.getPriority(),task4);
        taskMaxHeap.insert(task1.getPriority(), task1);
        taskMaxHeap.insert(task3.getPriority(), task3);
        taskMaxHeap.insert(task1.getPriority(), task1);
        taskMaxHeap.insert(task4.getPriority(), task4);


        System.out.println(taskMaxHeap.printArray());

        taskMaxHeap.increaseKey(4,task4);

        System.out.println(taskMaxHeap.printArray());
    }

}
