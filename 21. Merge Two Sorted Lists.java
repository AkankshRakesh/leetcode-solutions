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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;

        if(list1.val > list2.val){
            ans.val = list2.val;
            list2 = list2.next;
        }
        else{
            ans.val = list1.val;
            list1 = list1.next;
        }

        while(list1 != null && list2 != null){
            ListNode node = new ListNode();
            if(list1.val > list2.val){
                node.val = list2.val;
                list2 = list2.next;
            }
            else{
                node.val = list1.val;
                list1 = list1.next;
            }
            ans.next = node;
            ans = ans.next;
        }

        while(list1 != null){
            ListNode node = new ListNode();
            node.val = list1.val;
            list1 = list1.next;
            ans.next = node;
            ans = ans.next;
        }

        while(list2 != null){
            ListNode node = new ListNode();
            node.val = list2.val;
            list2 = list2.next;
            ans.next = node;
            ans = ans.next;
        }

        return head;
    }
}