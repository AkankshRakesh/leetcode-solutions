/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* node) {
        ListNode* prev = nullptr;
        ListNode* curr = node;
        while (curr != nullptr) {
            if (curr->next == nullptr) {
                curr->next = prev;
                return curr;
            }
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return nullptr;
    }

    void reorderList(ListNode* head) {
        if (!head || !head->next) return;

        int nodes = 0;
        ListNode* curr = head;
        while (curr != nullptr) {
            nodes++;
            curr = curr->next;
        }

        ListNode* tort = head;
        ListNode* hare = head;
        while (hare != nullptr && hare->next != nullptr && hare->next->next != nullptr) {
            tort = tort->next;
            hare = hare->next->next;
        }

        if (nodes % 2 == 0) tort = tort->next;

        tort->next = reverseList(tort->next);

        curr = head;
        ListNode* cutOff = tort;
        tort = tort->next;

        while (tort != nullptr) {
            ListNode* temp = curr->next;
            ListNode* tortTemp = tort->next;

            curr->next = tort;
            tort->next = temp;

            curr = temp;
            tort = tortTemp;
        }
        cutOff->next = nullptr;
    }
};
