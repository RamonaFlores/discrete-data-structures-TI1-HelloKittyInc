package util;

import model.Task;

import java.util.Arrays;
/**
 * The HashTableChaining class represents a generic hash table that uses chaining for collision resolution.
 * It allows you to insert, search, and delete key-value pairs and provides a string representation.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values associated with keys.
 */

public class HashTableChaining <K,V> implements IHash<K,V> {
    private HNode<K,V>[] table;
    private int slotNumber;
    /**
     * Constructs a hash table with a default number of slots.
     */
    public HashTableChaining(){
        slotNumber=15;
        table=new HNode[slotNumber];
    }
    /**
     * Constructs a hash table with a specified number of slots.
     *
     * @param slotNumber The number of slots or buckets in the table.
     */
    public HashTableChaining(int slotNumber){
        this.slotNumber=slotNumber;
        table=new HNode[slotNumber];
    }

    /**
     * Inserts a key-value pair into the hash table using separate chaining for collision resolution.
     *
     * @param key   The key to be inserted.
     * @param value The value associated with the key.
     */
    @Override
    public void insert(K key, V value) {
        int insertKey = hashFunction(key);
        HNode<K, V> nodeList = table[insertKey];

        if (nodeList == null) {
            // Si no existe una lista enlazada en este índice, crea una nueva con el nodo finalNode
            table[insertKey] = new HNode<>(key, value);
            return;
        }
        while (nodeList != null) {
            if (nodeList.getKey().equals(key)) {
                // Si la clave ya existe, actualiza el valor
                nodeList.setValue(value);
                return;
            }

            if (nodeList.getNextNode() == null) {
                // Llegaste al final de la lista enlazada, detén el bucle
                break;
            }

            nodeList = nodeList.getNextNode();
        }
        // Crea un nuevo nodo y agrégalo al final de la lista enlazada
        HNode<K, V> finalNode = new HNode<>(key, value);
        nodeList.setNextNode(finalNode);
    }
    /**
     * Computes the hash code for a given key and maps it to a slot in the hash table.
     *
     * @param key The key for which the hash code is computed.
     * @return The index of the slot where the key should be stored.
     */
    public int hashFunction(K key){
        int index = Math.abs(key.hashCode()%slotNumber);
        return index;
    }
    /**
     * Searches for a value associated with a given key in the hash table and return the last stacked node.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if the key is not found.
     */
    @Override
    public V search(K key) {
        //V is a generic type parameter representing the type of values that the value variable can hold
        // This means that the variable value can store a value of any type specified when the method is called
        // such as Integer, String, or any other type depending on how the method is used.
        //It also initializes the variable '
        V value = null;
        //the variable "insertKey" holds the value of the method hashFunction(key)
        //which computes the hash code of the given key.
        int searchKey = hashFunction(key);
        //This variable holds a
        HNode<K,V> searchNode = table[searchKey];
        while (searchNode != null) {
            if(searchNode.getKey().equals(key)){
                value = searchNode.getValue();
            }
            searchNode = searchNode.getNextNode();
        }
        return value;
    }

    public HNode searchNode(K key) {
        int searchKey = hashFunction(key);
        HNode<K, V> searchNode = table[searchKey];

        while (searchNode != null) {
            if (searchNode.getKey().equals(key)) {
                // Si encuentra la clave, devuelve el nodo
                return searchNode;
            }
            searchNode = searchNode.getNextNode();
        }
        // Si la clave no se encontró en la lista enlazada, devuelve null
        return null;
    }

    /**
     * Deletes a key-value pair from the hash table.
     *
     * @param key The key to be deleted.
     */
    @Override
    public void delete(K key) {
        int deleteKey = hashFunction(key);
        HNode<K, V> deleteNode = table[deleteKey];
        // Si no hay nodos en esta posición de la tabla, no hay nada que eliminar
        if (deleteNode == null) {
            return;
        }
        // Caso especial: si el primer nodo en la posición coincide con la clave
        if (deleteNode.getKey().equals(key)) {
            table[deleteKey] = deleteNode.getNextNode();
            return;
        }
        while (deleteNode != null) {
            if (deleteNode.getKey().equals(key)) {
                HNode<K, V> prev = deleteNode.getPreviousNode();
                HNode<K, V> next = deleteNode.getNextNode();
                if (prev != null) {
                    prev.setNextNode(next);
                }
                if (next != null) {
                    next.setPreviousNode(prev);
                }
                return; // Nodo encontrado y eliminado, sal del bucle
            }
            deleteNode = deleteNode.getNextNode();
        }
    }
    /**
     * Returns a string representation of the hash table.
     *
     * @return A string containing the table and slot information.
     */
    @Override
    public String toString() {
        return "HashTableChaining " +
                "Table: " + Arrays.toString(table) +
                "SlotNumber: " + slotNumber;
    }
    public String printNodes() {
        String message = "";

        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                message += table[i].toString() + "\n";
                if (table[i].getNextNode() != null) {
                    message += table[i].getNextNode().toString() + "\n";
                }
            }
        }
        return message;
    }
}

