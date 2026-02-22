/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public class Pair{
        int dist;
        Node node;
        public Pair(Node node, int dist){
            this.dist = dist;
            this.node = node;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair top = q.poll();
                hm.put(top.dist, top.node.data);
            
                Node node = top.node;
                if(node.left != null) q.offer(new Pair(node.left, top.dist - 1));
                if(node.right != null) q.offer(new Pair(node.right, top.dist + 1));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>(hm.keySet()); 
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++) ans.set(i, hm.get(ans.get(i)));
        
        return ans;
    }
}