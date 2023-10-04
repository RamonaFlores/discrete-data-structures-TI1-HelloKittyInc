package util;

public class HashTableChaining <K,V> implements IHash<K,V> {

    private HNode<K,V>[] table;
    private int slotNumber;


    public HashTableChaining(){
        slotNumber=10;
        table=new HNode[slotNumber];

    }
    public HashTableChaining(int slotNumber){
        this.slotNumber=slotNumber;
        table=new HNode[slotNumber];
    }
    @Override
    public void insert(K key, V value) {
        //the variable "insertKey" holds the value of the method hashFunction(key)
        //which computes the hash code of the given key.
        int insertKey = hashFunction(key);
        //'table' is an array-like structure used as the underlying storage for the HashTable
        //each index in the array corresponds to a possible slot(Hash code)

        //"table[insertKey]" is an expressioon that retrieves at the index specified by 'insertKey'
        //in the 'table' array . This element is expected to be:

        // a reference to the head of the linked list in the  slot
        // or null if the slot is empty (meaning the LL has not been created yet).
        HNode<K, V> nodeList = table[insertKey];
        //this conditional statement basically checks if "nodeList" is equal to null
        //Remember that in java "null" represents the absence of an object or simply
        // a reference to no object, in other words it does not reference any object within the program's memory.
        if (nodeList == null) {
            //this line of code is responsible for inserting a new key-value pair into the linked list associated with
            // the hash code insertKey in the hash table
            // If there is no existing-linked list at that index (table[insertKey] is null)
            // it creates a new linked list with a single node containing the provided key and value.
            // If a linked list already exists at that index, it adds the new node to the end of the existing list
            // thus handling collision resolution using separate chaining.
            table[insertKey] = new HNode<>(key, value);
            return; // Exit the method if the list is empty
        }
        //Sets up a loop that continues executing as long as the "nodeList" variable is not null.
        //this loop is used to traverse through the linked list.

        while (nodeList != null) {
            //a conditional statement that checks whether the key of the current node (nodeList)
            //in the linkedList is equal to the provided "key".
            //if they are equal it means that the key you're trying to insert already exists in the linked list
            //it helps identify whether a key already exists in the structure
            // allowing duplicate handling or existing values updating
            if (nodeList.getKey().equals(key)) {
                //this line is used to update the value of the value associated with the current node
                //this line is tipically used to handle cases where you have a duplicated key
                nodeList.setValue(value);
                return;
            }
            // Checks whether the next node in the linked list
            // after the current node represented by "nodeList",
            // is "null".
            if  (nodeList.getNextNode() == null){
                //is used to update the reference nodeList to point to the next node in the linked list.
                nodeList = nodeList.getNextNode();
                //the loop stops here because there are no more nodes to traverse.
                break;
            }
        }

        // Create a new node and add it to the end of the linked list
        HNode<K, V> finalNode = new HNode<>(key, value);
        //You update the next reference of the current node to point to the new node,
        // effectively inserting it into the list at the desired position.
        nodeList.setNextNode(finalNode);
    }
    public int hashFunction(K key){
        int index = key.hashCode()%slotNumber;
        return index;
    }

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

    @Override
    public void delete(K key) {
        int deleteKey = hashFunction(key);
        HNode<K,V> deleteNode = table[deleteKey];
        while (deleteNode != null){
            if(deleteNode.getKey().equals(key)){
                HNode<K,V> prev = deleteNode.getPreviousNode();
                HNode<K,V> next = deleteNode.getNextNode();
                prev.setNextNode(next);
                next.setPreviousNode(prev);
            }
            deleteNode = deleteNode.getNextNode();
        }
    }
}

