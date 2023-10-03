package util;

public class HashTableChaining <K,V> implements IHash<K,V> {

    private HNode[] slots;
    private int slotNumber;


    public HashTableChaining(){

    }
    @Override
    public boolean insert(K key, V value) {
        HNode<K,V> node = new HNode<>(key,value);

        slotNumber++;
        slots = new HNode[slotNumber];

        while(true){
            int j = hashFunction(key, value);

            if (slots[j] == null) {
                slots[j] = node;
            } else {
                node.setNextNode(slots[j]);
                slots[j].setNextNode(node);
                return true;
            }
        }
    }
    public int hashFunction(K key, V value){
        int index = key.hashCode()%slotNumber;
        return index;
    }

    @Override
    public V search(K key) {
        int i = 0;
        return null;
    }

    @Override
    public void delete(K key) {
    }
}

