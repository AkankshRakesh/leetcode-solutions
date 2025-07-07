/**
 * Definition for singly-linked list.
 */

class Solution {
public:
    ListNode* removeNodes(ListNode* head) {
        stack<ListNode*> st;

        while (head != nullptr) {
            while (!st.empty() && st.top()->val < head->val) {
                st.pop();
            }
            st.push(head);
            head = head->next;
        }

        vector<ListNode*> nodes;

        while (!st.empty()) {
            nodes.push_back(st.top());
            st.pop();
        }

        reverse(nodes.begin(), nodes.end());

        for (size_t i = 0; i < nodes.size() - 1; ++i) {
            nodes[i]->next = nodes[i + 1];
        }

        if (!nodes.empty()) {
            nodes.back()->next = nullptr;
            return nodes[0];
        }

        return nullptr;
    }
};
