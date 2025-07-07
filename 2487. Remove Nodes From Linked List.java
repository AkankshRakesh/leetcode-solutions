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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null){
            while (!stack.isEmpty() && stack.peek().val < head.val) stack.pop();
            stack.push(head);
            head = head.next;
        }

        for(int i = 0; i < stack.size() - 1; i++) stack.elementAt(i).next = stack.elementAt(i + 1);
        
        stack.peek().next = null;
        return stack.elementAt(0);
    }
}