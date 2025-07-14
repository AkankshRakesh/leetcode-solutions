
class Solution {
public:
    int getDecimalValue(ListNode* head) {
        ListNode* node = head;
        int len = 0;

        while (node != nullptr) {
            len++;
            node = node->next;
        }

        len--; 
        node = head;
        int ans = 0;

        while (node != nullptr) {
            if (node->val == 1) {
                ans += pow(2, len);
            }
            node = node->next;
            len--;
        }

        return ans;
    }
};
