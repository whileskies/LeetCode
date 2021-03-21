#include <iostream>
#include <algorithm>
#include "../common/listnode.h"

using namespace std;

class Solution {
public:
    ListNode* reverseBetween0(ListNode* head, int left, int right) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;

        ListNode* p = dummy;
        for (int i = 0; i < left - 1; i++)
            p = p->next;
        ListNode* firstTail = p;
        for (int i = 0; i < right - left + 1; i++)
            p = p->next;
        ListNode* secondHead = p->next;
        p->next = nullptr;

        ListNode* rHead = firstTail->next;
        firstTail->next = nullptr;

        ListNode* newHead = reverseNode(rHead);
        firstTail->next = newHead;
        rHead->next = secondHead;
        
        return dummy->next;
    }

    ListNode* reverseNode(ListNode* root) {
        ListNode* pre = nullptr;
        ListNode* cur = root;
        ListNode* next;

        while (cur != nullptr) {
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* pre = dummy;

        for (int i = 0; i < left - 1; i++)
            pre = pre->next;
        
        ListNode* cur = pre->next;

        for (int i = 0; i < right - left; i++) {
            ListNode* next = cur->next;
            cur->next = next->next;
            next->next = pre->next;
            pre->next = next;
        }

        return dummy->next;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    ListNode* root = stringToListNode("[1, 2]");
    root = s->reverseBetween(root, 1, 2);
    prettyPrintLinkedList(root);

    return 0;
}
