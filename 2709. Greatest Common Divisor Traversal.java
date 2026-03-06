class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int i){
            if(parent[i] != i) return parent[i] = find(parent[i]);
            return i;
        }

        public boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2) return false;
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p2] = p1;
                rank[p1]++;
            }

            return true;
        }
    }
    
    public boolean canTraverseAllPairs(int[] nums) {
        int max = nums[0];
        HashSet<Integer> numbers = new HashSet<>();
        boolean allOne = true;
        for(int num : nums){
            if(num != 1) allOne = false;
            numbers.add(num);
            max = Math.max(max, num);
        }
        if(allOne && nums.length > 1) return false;

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int i = 2; i <= max; i++){
            if(isPrime[i]){
                for(int j = i + i; j <= max; j += i){
                    if(!numbers.contains(j)) continue;
                    ArrayList<Integer> temp = adj.getOrDefault(j, new ArrayList<>());
                    temp.add(i);
                    adj.put(j, temp);
                    isPrime[j] = false;
                }
            }
        }

        DSU dsu = new DSU(max + 1);
        for(Map.Entry<Integer, ArrayList<Integer>> ele : adj.entrySet()){
            int node = ele.getKey();
            for(int factors : ele.getValue()) dsu.union(node, factors);
        }

        int parent = dsu.find(nums[0]);
        for(int num : nums){
            if(parent != dsu.find(num)) return false;
        }

        return true;
    }
}