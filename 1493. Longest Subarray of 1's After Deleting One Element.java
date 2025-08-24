class Solution {
    public int longestSubarray(int[] nums) {
        Map<Integer, Integer> hm = new TreeMap<>();
        int counter = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                counter++;
            }
            if(nums[i] == 0){
                if(counter == 0) continue;
                hm.put(i - counter, counter);
                counter = 0;
            } 
        }
        if(counter != 0){
            hm.put(n - counter, counter);
        }

        int prevInd = -1, prevCount = 0;
        int ans = 0;
        if (hm.size() == 1 && hm.containsKey(0) && hm.get(0) == n) {
            return hm.values().iterator().next() - 1;
        }

        for(Map.Entry<Integer,Integer> ele : hm.entrySet()){
            int ind = ele.getKey();
            int count = ele.getValue();

            ans = Math.max(ans, count);

            if (prevInd != -1 && ind - (prevInd + prevCount) == 1) {
                ans = Math.max(ans, prevCount + count);
            }

            prevInd = ind;
            prevCount = count;
        }

        return ans;
    }
}