class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int vertex){
            if(parent[vertex] != vertex) parent[vertex] = find(parent[vertex]);
            return parent[vertex];
        }

        public void union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2) return;
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
    
    public boolean isSimilar(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count == 0 || count == 2;
    }
    public int numSimilarGroups(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<>();
        int index = 0;
        for(String str : strs) hm.put(str, index++);
        DSU dsu = new DSU(strs.length);

        int ans = 0;
        for(int i = 0; i < strs.length; i++){
            for(int j = i + 1; j < strs.length; j++){
                if(isSimilar(strs[i], strs[j])) dsu.union(i, j);
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < strs.length; i++){
            if(hm.get(strs[i]) == i) hs.add(dsu.find(i));
        }

        return hs.size();
    }
}