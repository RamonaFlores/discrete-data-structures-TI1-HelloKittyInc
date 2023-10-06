package test;
import model.Task;
import org.junit.jupiter.api.*;
import util.MaxHeap;

public class MaxHeapTest {

    @Test
    public void testHeap(){
        MaxHeap<Task> taskMaxHeap = new MaxHeap<>(10);

        Task task3 = new Task("HOLA","ADIOS","ANDRES",true,2);
        Task task4 = new Task("HOLA","ADIOS","JUANA",true,4);
        Task task5 = new Task("HOLA","ADIOS","SCAMILO",true,1);
        Task task1 = new Task("HOLA","ADIOS","MARIANA",true,4);
        Task task2 = new Task("HOLA","ADIOS","MARIA",true,3);

        taskMaxHeap.insert(task4.getPriority(), task4);
        taskMaxHeap.insert(task5.getPriority(), task5);
        taskMaxHeap.insert(task3.getPriority(), task3);
        taskMaxHeap.insert(task1.getPriority(), task1);
        taskMaxHeap.insert(task2.getPriority(), task2);



        System.out.println(taskMaxHeap.printArray());

        //Assertions.assertDoesNotThrow(taskMaxHeap.printArray());
    }



}
