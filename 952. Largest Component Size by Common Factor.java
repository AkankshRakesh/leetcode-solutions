class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int n){
            if(parent[n] != n) return parent[n] = find(parent[n]);
            return n;
        }

        public boolean union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return false;
            if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else{
                parent[p2] = p1;
                rank[p1]++;
            }
            return true;
        }
    }

    public int largestComponentSize(int[] nums) {
        int max = nums[0];
        for(int num : nums) max = Math.max(max, num);

        DSU dsu = new DSU(max + 1);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 1;
        for(int num : nums){
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0){
                    dsu.union(i, num);
                    dsu.union(i, num / i);
                }
            }
        }
        for(int num : nums){
            int parent = dsu.find(num);
            hm.put(parent, hm.getOrDefault(parent, 0) + 1);
            ans = Math.max(ans, hm.get(parent));
        }

        return ans;
    }
}