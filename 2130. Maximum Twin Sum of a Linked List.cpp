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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }

        curr = head;
        int ans = 0;
        int index = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(curr != null){
            int past = n - 1 - index;
            if(past > index) arr.add(curr.val);
            else ans = Math.max(ans, arr.get(past) + curr.val);
            curr = curr.next;
            index++;
        }

        return ans;
    }
}