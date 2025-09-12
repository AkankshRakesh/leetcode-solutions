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
    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            if (curr.next == null) {
                curr.next = prev;
                return curr;
            }
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return null;
    }

    public void reorderList(ListNode head) {
        int nodes = 0;
        ListNode tort = head;
        ListNode hare = head;
        ListNode curr = head;
        while(curr != null){
            nodes++;
            curr = curr.next;
        }
        while(hare != null && hare.next != null && hare.next.next != null){
            tort = tort.next;
            hare = hare.next.next;
        }
        // System.out.println(tort.val);
        if(nodes % 2 == 0) tort = tort.next;
        tort.next = reverseList(tort.next);
        curr = head;

        ListNode cutOff = tort;
        tort = tort.next;
        System.out.println(nodes);
        while(tort != null){
            ListNode temp = curr.next;
            ListNode tortTemp = tort.next;
            curr.next = tort;
            tort.next = temp;
            curr = temp;
            tort = tortTemp;
        }
        cutOff.next = null;
    }
}