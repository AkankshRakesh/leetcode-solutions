class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr) return head;
        
        ListNode* next = head->next;
        ListNode* prev = nullptr;

        while (next != nullptr) {
            head->next = prev;
            ListNode* temp = next->next;
            next->next = head;
            prev = head;
            head = next;
            next = temp;
        }

        return head;
    }
};