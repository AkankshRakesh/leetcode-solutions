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
    public void localReverse(ListNode prev, ListNode start, ListNode end){
        ListNode stoppingPoint = end;
        while(start != stoppingPoint){
            ListNode next = start.next;
            start.next = end;
            end = start;
            start = next;
        }
        if(prev == null) prev = end;
        else prev.next = end;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = head;
        int temp = k - 1;
        while(ans != null && temp != 0){
            ans = ans.next;
            temp--;
        }
        // if(ans == null) return head;
        ListNode start = head;
        ListNode end = head;
        ListNode prev = null;
        while(end != null){
            int counter = 0;
            while(end != null && counter < k){
                end = end.next;
                counter++;
            }
            if(end == null && counter != k) break;
            ListNode nextPrev = start;
            localReverse(prev,start, end);
            start = end;
            prev = nextPrev;
        }
        
        return ans;
    }
}