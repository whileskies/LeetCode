#include <iostream>
#include <algorithm>
#include <cmath>
#include "../common/binarytree.h"

using namespace std;

class Solution {
private:
    bool isBal = true;
public:
    bool isBalanced(TreeNode* root) {
        getHeigth(root);
        return isBal;
    }

    int getHeigth(TreeNode* root) {
        if (root == nullptr) return 0;

        int left = getHeigth(root->left);
        int right = getHeigth(root->right);

        if (abs(left - right) > 1)
            isBal = false;
        
        return max(left, right) + 1;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    TreeNode* root = stringToTreeNode("[3,9,20,null,null,15,7]");
    cout << s->isBalanced(root) << endl;

    return 0;
}
