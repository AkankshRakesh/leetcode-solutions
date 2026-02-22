class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prereq, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[n];

        for(int[] req : prereq){
            ArrayList<Integer> temp = adj.getOrDefault(req[0], new ArrayList<>());
            temp.add(req[1]);
            adj.put(req[0], temp);
            inDeg[req[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int index = 1;
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0){
                q.offer(i);
                hm.put(i, new HashSet<>());
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int vertex = q.poll();
                if(!adj.containsKey(vertex)) continue;

                for(int neig : adj.get(vertex)){
                    inDeg[neig]--;
                    HashSet<Integer> hs = hm.getOrDefault(neig, new HashSet<>());
                    for(int predes : hm.get(vertex)) hs.add(predes);
                    hs.add(vertex);
                    hm.put(neig, hs);

                    if(inDeg[neig] == 0){
                        q.offer(neig);
                    }
                }
            }
            index++;
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            if(hm.get(query[1]).contains(query[0])) ans.add(true);
            else ans.add(false);
        }

        return ans;
    }
}