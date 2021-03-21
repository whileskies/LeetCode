package p0706;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] table;

    static class Node {
        int key;
        int value;
    }


    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            table[i] = new LinkedList<Node>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        Iterator<Integer> it = table[index].iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val == key)
                return;
        }
        table[index].offerLast(key);
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Integer> it = table[index].iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val == key) {
                it.remove();
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        Iterator<Integer> it = table[index].iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val == key) {
                return true;
            }
        }

        return false;
    }

    private int hash(int key) {
        return key % BASE;
    }


    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
        myHashSet.add(1000000);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

