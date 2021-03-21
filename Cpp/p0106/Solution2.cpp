#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <unordered_map>
#include "../common/binarytree.h"

using namespace std;

class Solution {
private:
    unordered_map<int, int> index;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i = 0; i < inorder.size(); i++) {
            index[inorder[i]] = i;
        }
        return buildTreeHelper(0, inorder.size() - 1, 0, postorder.size() - 1, inorder, postorder);
    }

    TreeNode* buildTreeHelper(int il, int ir, int pl, int pr, vector<int>& inorder, vector<int>& postorder) {
        if (il > ir)
            return NULL;
        int node = postorder[pr];
        TreeNode *root = new TreeNode(node);

        int pos = index[node];

        int leftLen = pos - il;

        root->left = buildTreeHelper(il, pos - 1, pl, pl + leftLen - 1, inorder, postorder);
        root->right = buildTreeHelper(pos + 1, ir, pl + leftLen, pr - 1, inorder, postorder);

        return root;
    }
};


int main(int argc, char const *argv[])
{
    Solution *s = new Solution();
    vector<int> inorder = {9,3,15,20,7};
    vector<int> postorder = {9,15,7,20,3};
    TreeNode *root = s->buildTree(inorder, postorder);
    
    prettyPrintTree(root);

    return 0;
}
