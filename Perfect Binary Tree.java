/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    int leafLevel = 0;
    public boolean trav(Node root, int level){
        if(root == null) return true;
        if((root.left == null && root.right != null) || (root.left != null && root.right == null)) return false;
        
        if(root.left == null && root.right == null && level != leafLevel) return false;
        
        return trav(root.left, level + 1) && trav(root.right, level + 1);
    }
    public boolean isPerfect(Node root) {
        Node node = root;
        int count = 0;
        while(node != null){
            count++;
            node = node.left;
        }
        leafLevel = count;
        return trav(root, 1);
    }
}