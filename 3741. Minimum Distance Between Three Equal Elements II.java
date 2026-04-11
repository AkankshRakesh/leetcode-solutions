class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, int[]> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int[] coords = hm.getOrDefault(num, new int[]{-1, -1, -1});

            if(coords[0] == -1) coords[0] = i;
            else if(coords[1] == -1) coords[1] = i;
            else if(coords[2] == -1){ 
                coords[2] = i;
                ans = Math.min(ans, (coords[1] - coords[0]) + (coords[2] - coords[1]) + (coords[2] - coords[0]));
            }
            else{
                coords[0] = coords[1];
                coords[1] = coords[2];
                coords[2] = i;
                ans = Math.min(ans, (coords[1] - coords[0]) + (coords[2] - coords[1]) + (coords[2] - coords[0]));
            }
            hm.put(num, coords);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}