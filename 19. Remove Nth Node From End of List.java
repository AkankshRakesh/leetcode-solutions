/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        ListNode end = head;
        end = end.next;
        int temp = n;
        while(end != null && temp != 0){
            end = end.next;
            temp--;
        }
        while(end != null){
            start = start.next;
            end = end.next;
        }
        if(temp != 0){
            return head.next;
        }
        start.next = start.next.next;
        return head;
    }
}