package p0341;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {
    private Integer num;
    private List<NestedInteger> list;
    private boolean isNum = true;

    public NestedIntegerImpl(Integer num) {
        this.num = num;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
        this.isNum = false;
    }

    @Override
    public boolean isInteger() {
        return isNum;
    }

    @Override
    public Integer getInteger() {
        if (isNum) return num;
        else return null;
    }

    @Override
    public List<NestedInteger> getList() {
        if (isNum) return null;
        else return list;
    }
}

class NestedIterator implements Iterator<Integer> {
    private Deque<Integer> indexStack;
    private Deque<List<NestedInteger>> nestedStack;

    public NestedIterator(List<NestedInteger> nestedList) {
        indexStack = new LinkedList<>();
        nestedStack = new LinkedList<>();
        indexStack.push(-1);
        nestedStack.push(nestedList);
    }

    @Override
    public Integer next() {
        List<NestedInteger> cur = nestedStack.peek();
        int index = indexStack.peek();

        return cur.get(index).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (true) {
            if (indexStack.isEmpty()) break;

            while (!indexStack.isEmpty() && !nestedStack.isEmpty() &&
                    indexStack.peek() + 1 == nestedStack.peek().size()) {
                indexStack.pop();
                nestedStack.pop();
            }

            if (indexStack.isEmpty()) break;

            int nextIndex = indexStack.peek() + 1;
            List<NestedInteger> top = nestedStack.peek();

            indexStack.pop();
            indexStack.push(nextIndex);
            if (!top.get(nextIndex).isInteger()) {
                nestedStack.push(top.get(nextIndex).getList());
                indexStack.push(-1);
            } else {
                break;
            }
        }

        return !indexStack.isEmpty();
    }

    public static void main(String[] args) {
        NestedInteger a = new NestedIntegerImpl(1);
        NestedInteger b = new NestedIntegerImpl(1);
        List<NestedInteger> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        NestedInteger d = new NestedIntegerImpl(c);

        NestedInteger e = new NestedIntegerImpl(2);

        NestedInteger a1 = new NestedIntegerImpl(1);
        NestedInteger b1 = new NestedIntegerImpl(1);
        List<NestedInteger> c1 = new ArrayList<>();
        c1.add(a);
        c1.add(b);
        NestedInteger d1 = new NestedIntegerImpl(c);

        List<NestedInteger> lists = Arrays.asList(d, e, d1);

        NestedIterator it = new NestedIterator(lists);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

