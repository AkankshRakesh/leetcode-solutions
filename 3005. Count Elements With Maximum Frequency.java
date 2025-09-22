class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int maxFreq = hm.get(nums[0]);
        int ans = 0;
        for(Map.Entry<Integer, Integer> ele : hm.entrySet()){
            if(ele.getValue() == maxFreq) ans++;
            else if(ele.getValue() > maxFreq){
                maxFreq = ele.getValue();
                ans = 1;
            }
        }

        return ans * maxFreq;
    }
}