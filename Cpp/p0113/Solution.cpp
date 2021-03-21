#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include "../common/binarytree.h"

using namespace std;



class Solution {
public:
    // bfs
    struct Node {
        TreeNode* root;
        int val;
        vector<int> path;
    };

    vector<vector<int>> pathSum0(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        if (root == nullptr)
            return res;
        
        queue<Node> q;
        q.push({root, root->val, {root->val}});

        while (!q.empty()) {
            Node node = q.front();
            q.pop();

            if (node.root->left == nullptr && node.root->right == nullptr && node.val == targetSum) {
                res.push_back(node.path);
            }

            if (node.root->left != nullptr) {
                vector<int> nPath = node.path;
                nPath.push_back(node.root->left->val);
                q.push({node.root->left, node.val + node.root->left->val, nPath});
            }

            if (node.root->right != nullptr) {
                vector<int> nPath = node.path;
                nPath.push_back(node.root->right->val);
                q.push({node.root->right, node.val + node.root->right->val, nPath});
            }
        }

        return res;
    }


    // dfs
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        vector<int> path;
        dfs(root, targetSum, path, res);
        return res;
    }

    void dfs(TreeNode* root, int targetSum, vector<int>& path, vector<vector<int>>& res) {
        if (root == nullptr) return;
        
        path.push_back(root->val);
        if (root->left == nullptr && root->right == nullptr && root->val == targetSum) {
            res.push_back(path);
        }
        
        dfs(root->left, targetSum - root->val, path, res);
        dfs(root->right, targetSum - root->val, path, res);
        path.pop_back();
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
