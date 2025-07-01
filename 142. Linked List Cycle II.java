/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode findConn(ListNode curr){
        HashMap<ListNode, Integer> hm = new HashMap<ListNode, Integer>();
        int ind = 0;
        while(!hm.containsKey(curr)){
            hm.put(curr, ind);
            ind++;
            curr = curr.next;
        }
        return curr;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return findConn(head);
        }

        return null;
    }
}