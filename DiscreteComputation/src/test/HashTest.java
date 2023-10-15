package test;

import model.Task;
import util.HashTableChaining;
import org.junit.jupiter.api.*;
import util.MaxHeap;

import static org.junit.jupiter.api.Assertions.*;

public class HashTest {
    private HashTableChaining<Integer,Task> hashTableChaining = new HashTableChaining<Integer, Task>();
    /**
     *
     * in this case, several tasks are added to the hashtable, the task searched by its key is printed, then it is searched using the search method and
     * compared if it is equal to the object associated to that key.
     *
     */
    @Test
    public void testHashSearch1(){

        Task task1 = new Task("TASK1", "...", "17/10/2023", true, 3);
        Task task2 = new Task("TASK2", "..", "18/10/2023", true, 4);
        Task task3 = new Task("TASK3", "...", "15/10/2023", true, 3);
        Task task4 = new Task("TASK4", "...", "16/10/2023", true, 2);
        Task task5 = new Task("TASK5", "...", "16/10/2023", true, 1);

        hashTableChaining.insert(6,task1);
        hashTableChaining.insert(2,task2);
        hashTableChaining.insert(5,task4);
        hashTableChaining.insert(4,task5);
        hashTableChaining.insert(3,task3);

        System.out.println("Nodo: " + hashTableChaining.search(5));

        assertSame(task4,hashTableChaining.search(5), "the last object stacked are the last added in the ");

    }
    /**
     *
     * In this case, several tasks are added to the hashtable, the task searched by its key is printed,
     * then deleted and searched again for that task, making sure it is null.
     *
     */
    @Test
    public void testHashDelete1(){
        Task task1 = new Task("TASK1", "...", "17/10/2023", true, 3);
        Task task2 = new Task("TASK2", "..", "18/10/2023", true, 4);
        Task task3 = new Task("TASK3", "...", "15/10/2023", true, 3);
        Task task4 = new Task("TASK4", "...", "16/10/2023", true, 2);
        Task task5 = new Task("TASK5", "...", "16/10/2023", true, 1);

        hashTableChaining.insert(3,task1);
        hashTableChaining.insert(2,task2);
        hashTableChaining.insert(1,task4);
        hashTableChaining.insert(4,task5);
        hashTableChaining.insert(5,task3);

        System.out.println("Nodo: " + hashTableChaining.search(4));
        hashTableChaining.delete(4);
        assertNull(hashTableChaining.search(4));

    }
    /**
     * in this case I first add a task with a special key,
     * look for that task in the hash to verify if it was added properly,
     * then delete it and then look for it again to verify if it was deleted properly.
     *
     */
    @Test
    public void testHashDelete2(){

        Task task1 = new Task("TASK1", "...", "17/10/2023", true, 3);
        Task task3 = new Task("TASK3", "...", "15/10/2023", true, 3);
        Task task4 = new Task("TASK4", "...", "16/10/2023", true, 2);
        Task task5 = new Task("TASK5", "...", "16/10/2023", true, 1);


        hashTableChaining.insert(1,task1);
        hashTableChaining.insert(2,task3);
        hashTableChaining.insert(3,task4);
        hashTableChaining.insert(4,task5);

        System.out.println("Node search" + hashTableChaining.searchNode(3));

        hashTableChaining.delete(3);
        assertNull(hashTableChaining.search(3));

        System.out.println("Node Delete: " + hashTableChaining.search(3));

        System.out.println();

        System.out.println("Node List: " + hashTableChaining.printNodes());

    }
}
