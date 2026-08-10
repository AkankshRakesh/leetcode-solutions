class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i = 1; i < parent.length; i++){
            ArrayList<Integer> temp = adj.getOrDefault(parent[i], new ArrayList<>());
            temp.add(i);
            adj.put(parent[i], temp);
        }

        long h = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        long ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                if(!adj.containsKey(node)) continue;
                for(int neig : adj.get(node)) q.offer(neig);
            }

            h++;
        }

        long d = 1;
        q.offer(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();

                ans += (long)(nums[node] * (h - d + 1));
                if(!adj.containsKey(node)) continue;
                for(int neig : adj.get(node)) q.offer(neig);
            }

            d++;
        }

        return ans;
    }
}