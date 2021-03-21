#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;


// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};


class Solution {
public:
    Node* connect0(Node* root) {
        if (root == nullptr) return root;
        queue<Node*> q;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            Node* pre = nullptr;
            for (int i = 0; i < size; i++) {
                Node* cur = q.front();
                q.pop();
                if (pre != nullptr) {
                    pre->next = cur; 
                }

                if (cur->left != nullptr) q.push(cur->left);
                if (cur->right != nullptr) q.push(cur->right);

                pre = cur;
            }
            pre->next = nullptr;
        }
        
        return root;
    }


    // 原地
    Node* connect1(Node* root) {
        if (root == nullptr) return root;
        
        Node* cur = root;
        while (cur != nullptr) {
            Node* pre = nullptr;
            Node* p = cur;
            while (p != nullptr) {
                if (p->left != nullptr && p->right != nullptr)
                    p->left->next = p->right;
                if (pre != nullptr) {
                    if (pre->right != nullptr && p->left != nullptr)
                        pre->right->next = p->left;
                }
                pre = p;
                p = p->next;
            }
            cur = cur->left;
        }

        return root;
    }

    // O(1) 简洁写法
    Node* connect2(Node* root) {
        if (root == nullptr) return root;
        
        Node* cur = root;
        while (cur->left != nullptr) {
            for (auto p = cur; p != nullptr; p = p->next) {
                p->left->next = p->right;
                if (p->next != nullptr) p->right->next = p->next->left;
            }
            cur = cur->left;
        }

        return root;
    }


    Node* connect(Node* root) {
        if (root == nullptr || root->left == nullptr)
            return root;
        root->left->next = root->right;
        if (root->next) 
            root->right->next = root->next->left;
        connect(root->left);
        connect(root->right);

        return root;
    }
};