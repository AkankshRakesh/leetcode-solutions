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
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode* curr = head;
        ListNode* next = head;
        k--;
        while(k){
            next = next -> next;
            k--;
        }
        ListNode* temp = next;
        while(next -> next != NULL){
            curr = curr -> next;
            next = next -> next;
        }
        cout << temp -> val << endl;
        cout << curr -> val << endl;
        int store = temp -> val;
        temp -> val = curr -> val;
        curr -> val = store;
        return head;
    }
};