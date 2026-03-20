package HashMap;

import java.util.LinkedList;

public class HashMap_Implementation_02 {

    /*
     * put : add and update if already exist.
     * 
     * get : value if key exists , null if key does'nt exist.
     * 
     * remove : the value associated with key if key exist , null if key does'nt
     * exist.
     * 
     */

    static class MyHashmap<K, V> {
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // the number of entries in map

        private LinkedList<Node>[] buckets;

        private void initBuckets(int N) {// N - capacity/ size of buckets array
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int HashFunc(K key) {
            int hc = key.hashCode();
            return (Math.abs(hc)) % buckets.length;
        }

        // traverses the linked list and looks for a node with key , if found it returns
        // tis index otherwise it return null
        private int searchInBucket(LinkedList<Node> ll, K key) {
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public MyHashmap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            for(var bucket : oldBuckets){
                for( var node : bucket){
                    put(node.key, node.value);;
                }
            }
        }

        // Size

        public int size() {// return number of entries in map
            return n;
        }

        // put

        public void put(K key, V value) { // insert and update
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei == -1) {// key doed'n exist and we have to enter a new node
                Node node = new Node(key, value);
                currBucket.add(node);
                n++;
            } else {
                // update case
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }

            if( n >= buckets.length * DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }

        // get

        public V get(K key) {
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if (ei != -1) { // key exist
                Node currNode = currBucket.get(ei);
                return currNode.value;
            } else {// doesn t exist
                return null;
            }
        }

        // remove

        public V remove(K key) {
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if (ei != -1) { // key exist
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }

            return null;
        }

    }

    public static void main(String[] args) {
        MyHashmap<String, Integer> mp = new MyHashmap<>();

        System.out.println("Testing put");
        mp.put("A", 1);
        mp.put("B", 2);
        mp.put("C", 3);
        mp.put("A", 10);
        mp.put("D", 1);
        System.out.println("testing size :" + mp.size());

        System.out.println(mp.get("A"));
        System.out.println(mp.get("D"));

        System.out.println("removing :" + mp.remove("C"));

    }
}
