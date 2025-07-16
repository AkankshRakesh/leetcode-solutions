/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node top = q.poll();
            
            if(top.left != null && top.right != null){
                if(top.data != top.left.data + top.right.data) return 0;
            }
            else if(top.left == null && top.right != null){
                if(top.data != top.right.data) return 0;
            }
            else if(top.right == null && top.left != null){
                if(top.data != top.left.data) return 0;
            }
            
            if(top.left != null) q.offer(top.left);
            if(top.right != null) q.offer(top.right);
        }
        
        return 1;
    }
}