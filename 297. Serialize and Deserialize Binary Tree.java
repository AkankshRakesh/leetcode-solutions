/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null-";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                size--;
                TreeNode node = q.poll();
                if(node == null){
                    sb.append("null+");
                }
                else{
                    q.offer(node.left);
                    q.offer(node.right);
                    sb.append(node.val + "+");
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        System.out.println(data);
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while(ind < data.length()){
            if(data.charAt(ind) == '+'){
                arr.add(sb.toString());
                sb = new StringBuilder();
            }
            else{
                sb.append(data.charAt(ind));
            }
            ind++;
        }
        arr.removeIf(s -> s.isEmpty());
        
        if(arr.size() == 0 || arr.get(0).equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr.get(0)));
        ind = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(ind < arr.size()){
            TreeNode node = q.poll();

            if (ind < arr.size()) {
                String left = arr.get(ind++);
                if (left.equals("null")) {
                    node.left = null;
                } else {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    node.left = leftNode;
                    q.offer(leftNode);
                }
            }

            if (ind < arr.size()) {
                String right = arr.get(ind++);
                if (right.equals("null")) {
                    node.right = null;
                } else {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    node.right = rightNode;
                    q.offer(rightNode);
                }
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));