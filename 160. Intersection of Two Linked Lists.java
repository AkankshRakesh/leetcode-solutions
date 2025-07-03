/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        int lenA = 0, lenB = 0;
        while(currA != null){
            lenA++;
            currA = currA.next;
        }
        while(currB != null){
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if(lenA > lenB){
            int diff = lenA - lenB;
            while(diff != 0){ 
                currA = currA.next;
                diff--;
            }
        }
        else if(lenB > lenA){
            int diff = lenB - lenA;
            while(diff != 0){ 
                currB = currB.next;
                diff--;
            }
        }


        while(currA != null && currB != null){
            if(currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}