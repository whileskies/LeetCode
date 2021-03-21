#include <iostream>
#include <algorithm>
#include <vector>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return helper(nums, 0, nums.size() - 1);
    }

    TreeNode* helper(vector<int>& nums, int left, int right) {
        if (left > right)
            return NULL;
        int mid = (right + left) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = helper(nums, left, mid - 1);
        root->right = helper(nums, mid + 1, right);

        return root;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    vector<int> nums = {-10, -3, 0, 5, 9};
    TreeNode* root = s->sortedArrayToBST(nums);
    prettyPrintTree(root);


    return 0;
}
