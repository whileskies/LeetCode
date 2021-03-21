package p0706;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] table;

    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            table[i] = new LinkedList<Node>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        Iterator<Node> it = table[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (key == node.key) {
                node.value = value;
                return;
            }
        }
        table[index].offerLast(new Node(key, value));
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Iterator<Node> it = table[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key == key) {
                it.remove();
                return;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        Iterator<Node> it = table[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key == key) {
                return node.value;
            }
        }

        return -1;
    }

    private int hash(int key) {
        return key % BASE;
    }


    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

