#include <iostream>
#include <algorithm>

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
    Node* connect(Node* root) {
        if (root == nullptr) return root;
        Node* cur = root;
        while (cur->left != nullptr) {
            Node* pre = nullptr;
            for (auto p = cur; p != nullptr; p = p->next) {
                if (p->left != nullptr) {
                    if (pre != nullptr) {
                        pre->next = p->left;
                        pre = p->left;
                    } else {
                        pre = p->left;
                    }
                }

                if (p->right != nullptr) {
                    if (pre != nullptr) {
                        pre->next = p->right;
                        pre = p->right;
                    } else {
                        pre = p->right;
                    }
                }

            }
            cur = cur->left;
        }

        return root;
    }
};