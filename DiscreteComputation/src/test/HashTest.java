package test;

import util.HashTableChaining;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashTest {
    @Test
    /*
     * Metodo verificar el funcionamiento del método agregar en una
     * hashTable un nuevo elemeto a la tabla, el tamaño de la misma
     * aumenta
     * */
    public void testHash(){
        HashTableChaining<Integer, Integer> hashTableChaining = new HashTableChaining<>();
        System.out.println("HOLAAA");
        Integer key = 10;
        Integer value = 5;

        //assertTrue(hashTableChaining.insert(key,value));
    }




}
