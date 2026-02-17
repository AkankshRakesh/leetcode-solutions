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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode ansHead = ans;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode head : lists){
            while(head != null){
                pq.offer(new ListNode(head.val));
                head = head.next;
            }
        }

        while(!pq.isEmpty()){
            if(ans == null) ans = pq.poll();
            else{
                ans.next = pq.poll();
                ans = ans.next;
            }
        }

        return ansHead.next;
    }
}