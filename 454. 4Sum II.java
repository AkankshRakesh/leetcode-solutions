class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num1 : nums1){
            for(int num2 : nums2) hm.put(num1 + num2, hm.getOrDefault(num1 + num2, 0) + 1);
        }
        
        int ans = 0;
        for(int num1 : nums3){
            for(int num2 : nums4){
                if(hm.containsKey(0 - num1 - num2)) ans += hm.get(0 - num1 - num2);
            }
        }

        return ans;
    }
}