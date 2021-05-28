package p0146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key;
        int value;
        Node pre, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Node head, tail;
    Map<Integer, Node> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-2, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) return -1;
        removeNode(node);
        addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node == null) {
            if (size >= capacity) {
                Node removed = removeTail();
                size--;
                cacheMap.remove(removed.key);
            }
            Node newNode = new Node(key, value);
            addHead(newNode);
            size++;
            cacheMap.put(key, newNode);
        } else {
            node.value = value;
            removeNode(node);
            addHead(node);
        }
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = node.next = null;
    }

    private void addHead(Node node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private Node removeTail() {
        Node last = tail.pre;
        removeNode(last);
        return last;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }
}
