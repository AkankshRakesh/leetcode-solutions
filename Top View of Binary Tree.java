/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();
        q.offer(root);
        distQ.offer(0);
        int dist = 0;
        hm.put(dist, root.data);
        
        while(!q.isEmpty()){
            Node top = q.poll();
            int topDist = distQ.poll();
            
            if(!hm.containsKey(topDist)){
                hm.put(topDist, top.data);
            }
            
            if(top.left != null){
                q.offer(top.left);
                distQ.offer(topDist - 1);
            }
            if(top.right != null){
                q.offer(top.right);
                distQ.offer(topDist + 1);
            }
        }
        
        for(Integer i : hm.values()) arr.add(i);
        return arr;
    }
}