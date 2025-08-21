/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* ans = new ListNode();
        int k = lists.size();
        ListNode* headAns = ans;

        while (true) {
            int leastInd = -1;
            for (int i = 0; i < k; i++) {
                ListNode* head = lists[i];
                if (head == nullptr) continue;

                if (leastInd == -1 || lists[leastInd]->val > lists[i]->val)
                    leastInd = i;
            }
            if (leastInd == -1) break;

            if (ans == nullptr) {
                ans = new ListNode(lists[leastInd]->val);
            } else {
                ans->next = new ListNode(lists[leastInd]->val);
                ans = ans->next;
            }

            lists[leastInd] = lists[leastInd]->next;
        }

        return headAns->next;
    }
};
