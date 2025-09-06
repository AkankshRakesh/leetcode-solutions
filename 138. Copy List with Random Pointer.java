/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> hm = new HashMap<>();
        Node curr = head;
        while(curr != null){
            hm.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        Node ans = new Node(curr.val);
        Node ansHead = ans;
        while(curr != null){
            Node temp = hm.get(curr);
            if(!hm.containsKey(curr.random)) temp.random = null;
            else{
                Node randomNode = hm.get(curr.random);
                temp.random = randomNode;
            }
            if(curr.next != null){
                temp.next = hm.get(curr.next);
            }
            curr = curr.next;
        }

        // for(Map.Entry<Node, Node> ele : hm.entrySet()){
        //     Node temp = ele.getValue();
        //     ans.next = temp;
        //     ans = ans.next;
        // }

        return hm.get(head);
    }
}