package p0078;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> tmpSubsets = new ArrayList<>(subsets);
            for (List<Integer> subset : tmpSubsets) {
                List<Integer> tmpSubset = new ArrayList<>(subset);
                tmpSubset.add(num);
                subsets.add(tmpSubset);
            }
        }

        return subsets;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }

    public static void main(String[] args) {

        Solution3 solution = new Solution3();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
