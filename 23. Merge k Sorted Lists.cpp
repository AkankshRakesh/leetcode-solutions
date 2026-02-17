class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* ans = new ListNode();
        ListNode* ansHead = ans;
        auto cmp = [](ListNode* a, ListNode* b) { return a->val > b->val; };
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);

        for (ListNode* head : lists) {
            while (head != nullptr) {
                pq.push(new ListNode(head->val));
                head = head->next;
            }
        }

        while (!pq.empty()) {
            if (ans == nullptr) ans = pq.top();
            else {
                ans->next = pq.top();
                ans = ans->next;
            }
            pq.pop();
        }

        return ansHead->next;
    }
};