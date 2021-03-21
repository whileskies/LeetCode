package p0705;

public class MyHashSet3 {
    private final int[] buckets = new int[31255];

    /** Initialize your data structure here. */
    public MyHashSet3() {

    }

    public void add(int key) {
        int index = key >> 5;
        int offset = key & 0x1f;
        buckets[index] |= 1 << offset;
    }

    public void remove(int key) {
        int index = key >> 5;
        int offset = key & 0x1f;
        buckets[index] &= ~(1 << offset);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key >> 5;
        int offset = key & 0x1f;
        return (buckets[index] >> offset & 1) == 1;
    }


    public static void main(String[] args) {
        MyHashSet3 myHashSet = new MyHashSet3();
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


