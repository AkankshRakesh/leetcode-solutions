/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int size = 1;
        boolean flag = false;
        arr.add(root.data);
        
        while(!q.isEmpty()){
            Node top = q.poll();
            
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);
            
            size--;
            if(flag){
                arr.add(top.data);
                flag = false;
            }
            if(size == 0){
                size = q.size();
                flag = true;
            }
        }
        
        return arr;
    }
}