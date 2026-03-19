class Solution {
public:
    ListNode* nodeAtRight = new ListNode(-1000);

    void reverse(ListNode* head, ListNode* tail, int currPos, int right, ListNode* revHead) {
        ListNode* next = new ListNode(-1000);
        if (tail->next != nullptr) next = tail->next;

        tail->next = head;
        if (currPos >= right - 1) {
            if (next->val == -1000) revHead->next = nullptr;
            else revHead->next = next;
            nodeAtRight = tail;
            return;
        }
        reverse(tail, next, currPos + 1, right, revHead);
    }

    ListNode* reverseBetween(ListNode* head, int left, int right) {
        int currPos = 1;
        if (left == right) return head;
        if (left == 1) {
            if (head->next == nullptr) return head;
            reverse(head, head->next, left, right, head);
            return nodeAtRight;
        }
        ListNode* tempHead = head;
        while (currPos != left - 1) {
            head = head->next;
            currPos++;
        }
        ListNode* revHead = head->next;
        reverse(head->next, head->next->next, left, right, revHead);
        std::cout << nodeAtRight->val << std::endl;
        head->next = nodeAtRight;
        return tempHead;
    }
};