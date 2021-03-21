#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    vector<TreeNode*> pre;

    void flatten0(TreeNode* root) {
        if (root == nullptr) return;
        preOrder(root);

        int i;
        for (i = 0; i < pre.size() - 1; i++) {
            pre[i]->right = pre[i + 1];
            pre[i]->left = nullptr;
        }
        
        pre[i]->right = nullptr;
        pre[i]->left = nullptr;
    }

    void preOrder(TreeNode* root) {
        if (root != nullptr) {
            pre.push_back(root);
            preOrder(root->left);
            preOrder(root->right);
        }
    }


    // stack
    void flatten1(TreeNode* root) {
        if (root == nullptr) return;
        stack<TreeNode*> s;

        TreeNode* pre = nullptr;
        TreeNode* cur;
        s.push(root);
        while (!s.empty()) {
            auto cur = s.top();
            s.pop();

            if (pre != nullptr) {
                pre->right = cur;
                pre->left = nullptr;
            }

            pre = cur;
            
            if (cur->right != nullptr) s.push(cur->right);
            if (cur->left != nullptr) s.push(cur->left);
        }
    }


    // 空间 O(1)
    void flatten(TreeNode* root) {
        if (root == nullptr) return;

        TreeNode* cur = root;
        while (cur != nullptr) {
            TreeNode* p = cur->left;
            if (p != nullptr) {
                while (p->right != nullptr)
                    p = p->right;
                p->right = cur->right;
                cur->right = cur->left;
                cur->left = nullptr;
            }
            cur = cur->right;
        }
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    TreeNode* root = stringToTreeNode("[1,2,5,3,4,null,6]");
    s->flatten(root);
    prettyPrintTree(root);


    return 0;
}

