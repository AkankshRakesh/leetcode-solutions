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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        int prevNode = -1, firstNode = -1, lastNode = -1;
        int minDist = Integer.MAX_VALUE;
        int index = 1;

        while(curr.next != null){
            ListNode next = curr.next;

            if((prev.val > curr.val && next.val > curr.val) || (prev.val < curr.val && next.val < curr.val)){
                if(prevNode != -1) minDist = Math.min(minDist, index - prevNode);
                prevNode = index;

                if(firstNode == -1) firstNode = index;
                else lastNode = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }
        // System.out.println(minDist + " " + firstNode + " " + lastNode);

        if(minDist == Integer.MAX_VALUE) return new int[]{-1, -1};
        return new int[]{minDist, lastNode - firstNode};
    }
}