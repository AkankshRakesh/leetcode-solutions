class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr || k == 0) return head;
        int n = 0;
        ListNode* temp = head;
        while (temp != nullptr) {
            temp = temp->next;
            n++;
        }

        k %= n;
        if (k == 0) return head;
        ListNode* fast = head;
        ListNode* slow = head;
        for (int i = 0; i < k; i++) fast = fast->next;

        while (fast->next != nullptr) {
            fast = fast->next;
            slow = slow->next;
        }

        ListNode* nextHead = slow->next;
        fast->next = head;
        slow->next = nullptr;
        head = nextHead;
        return head;
    }
};