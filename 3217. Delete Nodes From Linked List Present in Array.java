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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);

        ListNode prev = null;
        ListNode curr = head;
        while(curr.next != null){
            if(hs.contains(curr.val)){
                if(prev == null){
                    curr = curr.next;
                    head = curr;
                }
                else{
                    curr = curr.next;
                    prev.next = curr;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        if(hs.contains(curr.val)){
            if(prev == null) return null;
            else prev.next = null;
        }

        return head;
    }
}