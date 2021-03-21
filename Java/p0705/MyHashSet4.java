package p0705;

public class MyHashSet4 {
    private final int[] buckets = new int[31255];

    /** Initialize your data structure here. */
    public MyHashSet4() {

    }

    public void add(int key) {
        buckets[key >> 5] |= 1 << (key & 0x1f);
    }

    public void remove(int key) {
        buckets[key >> 5] &= ~(1 << (key & 0x1f));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return (buckets[key >> 5] >> (key & 0x1f) & 1) == 1;
    }


    public static void main(String[] args) {
        MyHashSet4 myHashSet = new MyHashSet4();
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


