class Solution {
    //暴力解法
    public int maxArea_1(int[] height) {
        int maxI = -1, maxHeight = -1;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxI = i;
            }
        }

        for (int j = 0; j < height.length; j++) {
            if (j != maxI) {
                maxArea = Math.max(maxArea, getArea(maxI, maxHeight, j, height[j]));
            }
        }

        return maxArea;
    }

    //双指针法
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

    //双指针，优化
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
