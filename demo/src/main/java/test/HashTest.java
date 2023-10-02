package test;


import org.junit.Test;
import util.HashTableChaining;
import static org.junit.jupiter.api.Assertions.*;

public class HashTest {

    @Test
    /*
     * Metodo que falla al
     * verificar el funcionamiento del método agregar
     * un nuevo elemeto a la tabla, el tamañi de la misma
     * aumenta a 1
     * */
    public void testHash(){

        HashTableChaining<Integer, Integer> hashTableChaining = new HashTableChaining<>();
        System.out.println("HOLAAA");
        Integer key = 10;
        Integer value = 5;
        assertTrue(hashTableChaining.insert(key,value),"Funciono");

    }
}

