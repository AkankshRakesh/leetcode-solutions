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
    void localReverse(ListNode* prev, ListNode* start, ListNode* end) {
        ListNode* stoppingPoint = end;
        while (start != stoppingPoint) {
            ListNode* next = start->next;
            start->next = end;
            end = start;
            start = next;
        }
        if (prev == nullptr) prev = end;
        else prev->next = end;
    }

    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* ans = head;
        int temp = k - 1;
        while (ans != nullptr && temp != 0) {
            ans = ans->next;
            temp--;
        }

        ListNode* start = head;
        ListNode* end = head;
        ListNode* prev = nullptr;

        while (end != nullptr) {
            int counter = 0;
            while (end != nullptr && counter < k) {
                end = end->next;
                counter++;
            }
            if (end == nullptr && counter != k) break;

            ListNode* nextPrev = start;
            localReverse(prev, start, end);
            start = end;
            prev = nextPrev;
        }

        return ans;
    }
};
