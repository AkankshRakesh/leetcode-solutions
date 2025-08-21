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
        int k = lists.length;
        ListNode headAns = ans;

        while(true){
            int leastInd = -1;
            for(int i = 0; i < k; i++){
                ListNode head = lists[i];
                if(head == null) continue;

                if(leastInd == -1 || lists[leastInd].val > lists[i].val) leastInd = i;
            }    
            if(leastInd == -1) break;
            if(ans == null) ans = new ListNode(lists[leastInd].val);
            else{
                ans.next = new ListNode(lists[leastInd].val);
                ans = ans.next;
            }
            lists[leastInd] = lists[leastInd].next;
        }

        return headAns.next;
    }
}