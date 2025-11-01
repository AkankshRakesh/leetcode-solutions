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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> hs(nums.begin(), nums.end());

        ListNode* prev = nullptr;
        ListNode* curr = head;

        while (curr != nullptr && curr->next != nullptr) {
            if (hs.count(curr->val)) {
                if (prev == nullptr) {
                    curr = curr->next;
                    head = curr;
                } else {
                    curr = curr->next;
                    prev->next = curr;
                }
            } else {
                prev = curr;
                curr = curr->next;
            }
        }

        if (curr != nullptr && hs.count(curr->val)) {
            if (prev == nullptr) return nullptr;
            else prev->next = nullptr;
        }

        return head;
    }
};