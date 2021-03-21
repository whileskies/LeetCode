#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <unordered_map>
#include "../common/binarytree.h"

using namespace std;


class Solution {
public:
    unordered_map<TreeNode*, TreeNode*> parent;

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        if (root == nullptr)
            return res;
        
        queue<pair<TreeNode*, int>> q;
        q.push({root, root->val});
        parent[root] = nullptr;

        while (!q.empty()) {
            auto e = q.front();
            q.pop();
            TreeNode* node = e.first;
            int total = e.second;

            if (node->left == nullptr && node->right == nullptr && total == targetSum) {
                vector<int> tmp;
                TreeNode* cur = node;
                while (cur != nullptr) {
                    tmp.push_back(cur->val);
                    cur = parent[cur];
                }
                reverse(tmp.begin(), tmp.end());
                res.push_back(tmp);
            }

            if (node->left != nullptr) {
                q.push({node->left, total + node->left->val});
                parent[node->left] = node;
            }

            if (node->right != nullptr) {
                q.push({node->right, total + node->right->val});
                parent[node->right] = node;
            }
        }

        return res;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    TreeNode* root = stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
    vector<vector<int>> res = s->pathSum(root, 22);

    for (auto& v : res) {
        for (auto& e : v) {
            cout << e << " ";
        }
        cout << endl;
    }
    

    return 0;
}
