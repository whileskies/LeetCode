#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTreeHelper(0, preorder.size() - 1, 0, inorder.size() - 1, preorder, inorder);
    }

    TreeNode* buildTreeHelper(int pl, int pr, int il, int ir, vector<int>& preorder, vector<int>& inoder) {
        if (pl > pr) return NULL;
        
        int node = preorder[pl];
        TreeNode *root = new TreeNode(node);
        
        int pos = -1;
        for (int i = il; i <= ir; i++) {
            if (inoder[i] == node) {
                pos = i;
                break;
            }
        }

        int leftLen = pos - il;
        int rightLen = ir - pos;

        root->left = buildTreeHelper(pl + 1, pl + leftLen, il, pos - 1, preorder, inoder);
        root->right = buildTreeHelper(pl + 1 + leftLen, pr, pos + 1, ir, preorder, inoder);

        return root;
    }
};


int main(int argc, char const *argv[])
{
    Solution *s = new Solution();
    vector<int> preorder = {3,9,20,15,7};
    vector<int> inorder = {9,3,15,20,7};
    TreeNode *root = s->buildTree(preorder, inorder);
    
    prettyPrintTree(root);
    
    return 0;
}

