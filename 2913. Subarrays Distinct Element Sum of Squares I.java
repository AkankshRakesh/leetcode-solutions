class Solution {
    public int sumCounts(List<Integer> nums) {
        int max = nums.get(0);
        for(int num : nums) max = Math.max(max, num);

        int[] freq = new int[max + 1];
        int ans = 0;
        for(int i = 0; i < nums.size(); i++){
            freq = new int[max + 1];
            int count = 0;
            for(int j = i; j < nums.size(); j++){
                if(freq[nums.get(j)] == 0) count++;
                freq[nums.get(j)]++;
                
                ans += count * count;
            }

        }

        return ans;
    }
}