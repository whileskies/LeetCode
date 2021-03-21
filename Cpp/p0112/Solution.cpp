#include <iostream>
#include <queue>
#include <algorithm>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    bool hasPathSum0(TreeNode* root, int targetSum) {
        if (root == nullptr) return false;
        if (root->left == nullptr && root->right == nullptr) {
            return targetSum == root->val;
        } 
        return hasPathSum(root->left, targetSum - root->val) || hasPathSum(root->right, targetSum - root->val);
    }

    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) return false;
        queue<pair<TreeNode*, int>> q;
        q.push({root, root->val});

        while (!q.empty()) {
            pair<TreeNode*, int> node = q.front();
            q.pop();

            if (node.first->left == nullptr && node.first->right == nullptr && node.second == targetSum)
                return true;
            
            if (node.first->left != nullptr) {
                q.push({node.first->left, node.second + node.first->left->val});
            }

            if (node.first->right != nullptr) {
                q.push({node.first->right, node.second + node.first->right->val});
            }
        }
        
        return false;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    TreeNode* root = stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
    cout << s->hasPathSum(root, 25) << endl;

    return 0;
}
