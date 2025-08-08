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
    public void add(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int ind1, int ind2, ArrayList<Integer> res, int carry){
        if(ind1 < 0 && ind2 < 0){
            if(carry == 1) res.add(1);
            return;
        }
        else if(ind1 < 0 && ind2 >= 0){
            if(carry == 1 && arr2.get(ind2) == 9){
                res.add(0);
                add(arr1, arr2, ind1, ind2 - 1, res, 1);
            }
            else{
                res.add(arr2.get(ind2) + carry);
                add(arr1, arr2, ind1, ind2 - 1, res, 0);
            }
        }
        else if(ind1 >= 0 && ind2 < 0){
            if(carry == 1 && arr1.get(ind1) == 9){
                res.add(0);
                add(arr1, arr2, ind1 - 1, ind2, res, 1);
            }
            else{
                res.add(arr1.get(ind1) + carry);
                add(arr1, arr2, ind1 - 1, ind2, res, 0);
            }
        }
        else{
            int sum = arr1.get(ind1) + arr2.get(ind2) + carry;
            if(sum >= 10){
                res.add(sum % 10);
                add(arr1, arr2, ind1 - 1, ind2 - 1, res, 1);
            }
            else{
                res.add(sum);
                add(arr1, arr2, ind1 - 1, ind2 - 1, res, 0);
            }
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        while(l1 != null){
            arr1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            arr2.add(l2.val);
            l2 = l2.next;
        }
        Collections.reverse(arr1);
        Collections.reverse(arr2);
        ArrayList<Integer> res = new ArrayList<>();
        add(arr1, arr2, arr1.size() - 1, arr2.size() - 1, res, 0);
        ListNode ans = new ListNode(res.get(0));
        ListNode head = ans;
        for(int i = 1; i < res.size(); i++){
            ans.next = new ListNode(res.get(i));
            // System.out.println(res.get(i));
            ans = ans.next;
        }

        return head;
    }
}