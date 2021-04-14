package p0341;

import java.util.*;

class NestedIterator2 implements Iterator<Integer> {
    private final List<Integer> nodes;
    private int index;

    public NestedIterator2(List<NestedInteger> nestedList) {
        nodes = new ArrayList<>();
        index = 0;
        for (var e : nestedList) {
            dfs(e);
        }
//        System.out.println(nodes);
    }

    private void dfs(NestedInteger x) {
        if (x.isInteger()) {
            nodes.add(x.getInteger());
        } else {
            for (var e : x.getList()) {
                dfs(e);
            }
        }
    }

    @Override
    public Integer next() {
        return nodes.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != nodes.size();
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

        NestedIterator2 it = new NestedIterator2(lists);
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

