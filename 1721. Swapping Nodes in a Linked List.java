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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        int tempK = k;
        ListNode second = head;
        boolean start = false;
        while(curr != null){
            len++;
            curr = curr.next;
            if(len - 1 == tempK || start){
                start = true;
                second = second.next;
            }
        }
        // System.out.println(second.val);
        curr = head;
        ListNode first = curr;
        k--;
        while(k != 0){
            k--;
            curr = curr.next;
            first = curr;
        }
        

        int temp = first.val;
        first.val = second.val;
        second.val = temp;


        return head;
    }
}