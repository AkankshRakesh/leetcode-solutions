/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        //set will tell me if I have intersected
        ListNode* current = headA;
        set<ListNode*> visited;
        
        while(current != nullptr){
            visited.insert(current);
            current = current->next;
        }

        current = headB;
        while(current != nullptr){
            if(visited.contains(current)) return current; 
            current = current->next;
        }
        return nullptr;

        
    }
};