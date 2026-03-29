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
        if(root == null) return "";
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        arr.add(root.val);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left == null) arr.add(1001);
            else{
                arr.add(node.left.val);
                q.offer(node.left);
            }
            
            if(node.right == null) arr.add(1001);
            else{
                arr.add(node.right.val);
                q.offer(node.right);
            }
        }

        for(int num : arr) System.out.print(num + " ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i));
            sb.append("#");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] vals = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;

        while(!q.isEmpty() && index < vals.length){
            TreeNode curr = q.poll();
            if(!vals[index].equals("1001")){
                curr.left = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(curr.left);
            }

            index++;
            if(index < vals.length && !vals[index].equals("1001")){
                curr.right = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(curr.right);
            }

            index++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));