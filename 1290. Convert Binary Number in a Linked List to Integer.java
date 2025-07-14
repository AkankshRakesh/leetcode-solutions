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
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }

        len--;

        node = head;
        int ans = 0;
        while(node != null){
            if(node.val == 1){
                ans += Math.pow(2, len);
            }
            node = node.next;
            len--;
        }

        return ans;
    }
}