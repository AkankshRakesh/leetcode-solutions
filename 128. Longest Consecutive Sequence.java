class Solution {
    public int recurse(HashMap<Integer, Integer> hm, boolean[] visited, int[] seq, int key){
        if(!hm.containsKey(key)) return 0;
        if(visited[hm.get(key)]) return seq[hm.get(key)];

        visited[hm.get(key)] = true;
        return seq[hm.get(key)] = 1 + recurse(hm, visited, seq, key + 1);
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        boolean[] visited = new boolean[nums.length];
        int[] seq = new int[nums.length];
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            if(!hm.containsKey(nums[i])) hm.put(nums[i], i);
        }
        
        for(int num : nums){
            recurse(hm, visited, seq, num);
            ans = Math.max(ans, seq[hm.get(num)]);
        }

        return ans;
    }
}