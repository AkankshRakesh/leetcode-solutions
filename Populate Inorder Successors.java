/*
class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public Node inorder(Node node, Node parent){
        if(node == null) return null;
        
        // inorder(node.left, node);
        Node leftTree = inorder(node.left, node);
        node.next = parent;
        if(node.right != null){
            node.next = inorder(node.right, parent);
            // return node;
        }
        
        return leftTree == null ? node : leftTree;
    }
    public void populateNext(Node root) {
        inorder(root, null);
    }
}