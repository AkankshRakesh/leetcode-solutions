class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int maxKey = nums[0];           
        int maxCount = hm.get(maxKey);       
        for (Map.Entry<Integer, Integer> ele : hm.entrySet()) {
            if (ele.getValue() > maxCount) {
                maxKey = ele.getKey();
                maxCount = ele.getValue();
            }
        }
        return maxKey;
    }
}