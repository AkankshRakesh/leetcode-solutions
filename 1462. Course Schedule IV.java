class Solution {
    public boolean check(int u, int v, HashMap<Integer, HashSet<Integer>> parents){
        return parents.get(v).contains(u);
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[n];
        HashMap<Integer, HashSet<Integer>> parents = new HashMap<>();
        int[] priority = new int[n];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int[] req : prerequisites){
            ArrayList<Integer> temp = adj.getOrDefault(req[0], new ArrayList<>());
            temp.add(req[1]);
            adj.put(req[0], temp);
            inDeg[req[1]]++;
        }

        for(int i = 0; i < n; i++){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(i);
            if(inDeg[i] == 0){
                q.offer(i);
            }
            parents.put(i, hs);
        }

        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i = 0; i < size; i++){
                int vertex = q.poll();
                priority[vertex] = ans;
                if(!adj.containsKey(vertex)) continue;
                for(int neig : adj.get(vertex)){
                    inDeg[neig]--;
                    HashSet<Integer> hs = parents.get(neig);
                    for(int nodes : parents.get(vertex)) hs.add(nodes);
                    parents.put(neig, hs);
                    if(inDeg[neig] == 0){
                        q.offer(neig);
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];

            if(!check(u, v, parents)) res.add(false);
            else res.add(true);
        }

        return res;
    }
}