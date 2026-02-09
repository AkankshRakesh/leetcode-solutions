/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node original, Node clone, HashMap<Integer, Node> hm){
        List<Node> clonedNeig = clone.neighbors;

        for(Node neig : original.neighbors){
            if(!hm.containsKey(neig.val)){
                Node next = new Node(neig.val, new ArrayList<>());
                hm.put(neig.val, next);
                clonedNeig.add(next);
                dfs(neig, next, hm);
            }
            else clonedNeig.add(hm.get(neig.val));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node clone = new Node(node.val, new ArrayList<>());
        HashMap<Integer, Node> hm = new HashMap<>();

        hm.put(node.val, clone);
        dfs(node, clone, hm);

        return clone;
    }
}