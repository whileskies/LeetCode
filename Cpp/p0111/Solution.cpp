#include <iostream>
#include <algorithm>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        return helper(root);
    }

    int helper(TreeNode* root) {
        if (root == nullptr) return 1e6;
        if (root->left == nullptr && root->right == nullptr) return 1;
        return min(helper(root->left), helper(root->right)) + 1;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    TreeNode* root = stringToTreeNode("[2,null,3,null,4,null,5,null,6]");
    cout << s->minDepth(root) << endl;


    return 0;
}
