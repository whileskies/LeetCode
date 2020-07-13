import java.util.Arrays;
import java.util.HashMap;

class Solution {
    /*
        所有的元素都要hash一次，空间占用大
        可以边扫描边hash，检查target-nums[i]是否已经hash过
        若hash过，则作为第1个数的索引，正在扫描的索引为第2个数索引，直接返回（只有一个答案）
        若未hash过，代表无此结果对，继续扫描

     */

    public int[] twoSum_1(int[] nums, int target) {
        int[] ret = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];

            if (map.containsKey(other)) {
                int otherIndex = map.get(other);
                if (i != otherIndex) {
                    ret[0] = i;
                    ret[1] = otherIndex;
                    break;
                }
            }
        }

        return ret;
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer otherIndex = map.get(target - nums[i]);

            if (otherIndex != null && otherIndex != i) {
                return new int[] {otherIndex, i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
