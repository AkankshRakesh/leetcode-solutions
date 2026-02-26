class Solution {
    class DSU{
        public int[] parent;
        public int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int n){
            if(parent[n] != n) return parent[n] = find(parent[n]);
            return n;
        }

        public boolean union(int u, int v){
            int p1 = find(u);
            int p2 = find(v);
            
            if(p1 == p2) return false;
            if(rank[p1] < rank[p2]){
                parent[p1] = p2; 
            }
            else if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else{
                rank[p1]++;
                parent[p2] = p1;
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            boolean isName = true;
            for(String email : accounts.get(i)){
                if(isName){
                    isName = !isName;
                    continue;
                }
                if(emailToIndex.containsKey(email)){
                    dsu.union(emailToIndex.get(email), i);
                }
                else{
                    emailToIndex.put(email, i);
                }
            }
        }
        
        HashMap<Integer, List<String>> indexHm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> ele : emailToIndex.entrySet()){
            int index = ele.getValue();
            String email = ele.getKey();
            int parent = dsu.find(index);
            if(parent == index){
                List<String> temp = indexHm.getOrDefault(index, new ArrayList<>());
                temp.add(email);
                indexHm.put(index, temp);
            }
            else{
                List<String> temp = indexHm.getOrDefault(parent, new ArrayList<>());
                temp.add(email);
                indexHm.put(parent, temp);
            }
        }

        for(Map.Entry<Integer, List<String>> ele : indexHm.entrySet()){
            List<String> curr = new ArrayList<>();
            curr.add(accounts.get(ele.getKey()).get(0));

            Collections.sort(ele.getValue());
            for(String str : ele.getValue()) curr.add(str);
            ans.add(curr);
        }

        return ans;
    }
}