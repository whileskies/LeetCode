package p0690;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(id, map);
    }

    private int dfs(int id, Map<Integer, Employee> map) {
        int sum = map.get(id).importance;
        for (int i : map.get(id).subordinates) {
            sum += dfs(i, map);
        }

        return sum;
    }
}
