#include <iostream>
#include <algorithm>
#include <vector>
#include "../common/listnode.h"
#include "../common/binarytree.h"

using namespace std;

class Solution {
public:
    TreeNode* sortedListToBST0(ListNode* head) {
        if (head == NULL) return NULL;
        int len = 0;
        ListNode* p = head;
        while (p) {
            len++;
            p = p->next;
        }
        
        if (len == 1) {
            TreeNode* root = new TreeNode(head->val);
            root->left = NULL;
            root->right = NULL;
            return root;
        }

        ListNode* pre = head;
        ListNode* cur = head;
        len >>= 1;
        while (len--) {
            pre = cur;
            cur = cur->next;
        }

        TreeNode* root = new TreeNode(cur->val);
        pre->next = NULL;
        root->left = sortedListToBST(head);
        ListNode* rHead = cur->next;
        root->right = sortedListToBST(rHead);

        return root;
    }


    TreeNode* sortedListToBST1(ListNode* head) {
        if (head == NULL) return NULL;
        int len = 0;
        for (auto p = head; p; p = p->next) len++;
        
        if (len == 1) return new TreeNode(head->val);

        ListNode* pre = head;
        for (int i = 0; i < len / 2 - 1; i++) pre = pre->next;

        TreeNode* root = new TreeNode(pre->next->val);
        root->right = sortedListToBST(pre->next->next);
        pre->next = NULL;
        root->left = sortedListToBST(head);

        return root;
    }


    // 快慢指针
    ListNode* getMid(ListNode* left, ListNode* right) {
        ListNode* slow = left;
        ListNode* fast = left;
        while (fast != right && fast->next != right) {
            slow = slow->next;
            fast = fast->next;
            fast = fast->next;
        }
        return slow;
    }

    TreeNode* build(ListNode* left, ListNode* right) {
        if (left == right) return nullptr;
        ListNode* mid = getMid(left, right);
        TreeNode* root = new TreeNode(mid->val);
        
        root->left = build(left, mid);
        root->right = build(mid->next, right);
        
        return root;
    }

    TreeNode* sortedListToBST(ListNode* head) {
        return build(head, nullptr);
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    ListNode* head = stringToListNode("[-10, -3, 0, 5, 9]");
    TreeNode* root = s->sortedListToBST(head);
    prettyPrintTree(root);


    return 0;
}
