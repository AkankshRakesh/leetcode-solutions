/**
 * Definition for singly-linked list.
 */

class Solution {
public:
    ListNode* findConn(ListNode* curr) {
        std::unordered_map<ListNode*, int> hm;
        int ind = 0;
        while (hm.find(curr) == hm.end()) {
            hm[curr] = ind;
            ind++;
            curr = curr->next;
        }
        return curr;
    }

    ListNode* detectCycle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) return findConn(head);
        }
        return nullptr;
    }
};
