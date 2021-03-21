#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        if (root == NULL) return res;

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty()) {
            vector<int> levelRes;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode *node = q.front();
                q.pop();
                levelRes.push_back(node->val);
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }

            res.push_back(levelRes);
        } 

        reverse(res.begin(), res.end());
        return res;
    }
};


int main(int argc, char const *argv[])
{
    Solution *s = new Solution();
    TreeNode *root = stringToTreeNode("[3,9,20,null,null,15,7]");
    vector<vector<int>> res = s->levelOrderBottom(root);

    for (auto &levelRes : res) {
        for (auto &e : levelRes) {
            cout << e << " ";
        }
        cout << endl;
    }

    return 0;
}
