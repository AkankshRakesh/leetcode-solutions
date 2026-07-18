class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Boolean[] color = new Boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());
        for(int[] dislike : dislikes){
            ArrayList<Integer> arr1 = adj.get(dislike[0]);
            ArrayList<Integer> arr2 = adj.get(dislike[1]);
            arr1.add(dislike[1]);
            arr2.add(dislike[0]);
            adj.put(dislike[0], arr1);
            adj.put(dislike[1], arr2);
        } 

        for(int i = 1; i <= n; i++){
            if(color[i] == null){
                q.offer(i);
                color[i] = true;

                while(!q.isEmpty()){
                    int node = q.poll();
                    Boolean nodeColor = color[node];

                    for(int neig : adj.get(node)){
                        if(color[neig] != null && color[neig] == nodeColor) return false;
                        if(color[neig] == null) q.offer(neig);
                        color[neig] = !nodeColor;
                    }
                }
            }
        }

        return true; 
    }
}