class Solution {
    //暴力解法
    public int maxArea_1(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, getArea(i, height[i], j, height[j]));
            }
        }

        return maxArea;
    }

    //双指针法
    /*
        area = Min(i, j) * (j - i)
        初始选择宽度最大的两边组成的面积，此面积因为宽度最大，可能为最大
        同时在宽度缩小的情况下，寻找可能更大的面积
        因为宽度变小，只有比初始情况下的短边更长才可能更大
        因此下次寻找可能最大面积时从短边向内靠近
        计算出面积后，寻找比该面积可能更大的面积，问题相同，问题规模缩小
    */
    public int maxArea_2(final int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, getArea(i, height[i], j, height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    //双指针，优化，短边向内移动时只计算比短边更长的情况
    public int maxArea(final int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, getArea(i, height[i], j, height[j]));
            int leftH = height[i], rightH = height[j];
            if (leftH < rightH) {
                while (height[++i] < leftH);
            } else {
                while (height[--j] < rightH);
            }
        }

        return maxArea;
    }

    private int getArea(int i1, int h1, int i2, int h2) {
        return Math.min(h1, h2) * Math.abs(i2 - i1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));

    }

}
