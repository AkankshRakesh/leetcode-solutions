class Solution {
    public int[] findOrder(int numCourses, int[][] preReq) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = preReq.length;
        int[] inDeg = new int[numCourses];

        for(int i = 0; i < n; i++){
            int u = preReq[i][1];
            int v = preReq[i][0];
            
            if(adj.containsKey(u)) adj.get(u).add(v);
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(v);
                adj.put(u,arr);
            }

            inDeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(inDeg[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int top = q.poll();
            if(adj.containsKey(top)){
                for(int nb: adj.get(top)){
                    inDeg[nb]--;
                    if(inDeg[nb] == 0) q.offer(nb);
                }
            }
            if(index >= numCourses) return new int[]{};
            res[index++] = top;
        }

        if(index != numCourses) return new int[]{};
        return res;
    }
}