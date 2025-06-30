class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        hm.put(0, 1);
        int ansCount = 0;
        for(int num: nums){
            sum += num;
            if(hm.containsKey(sum - k)){
                ansCount += hm.get(sum - k);
            }
            
            if(hm.containsKey(sum)){
                int count = hm.get(sum);
                hm.put(sum, count + 1);
            }
            else hm.put(sum, 1);
        }
        return ansCount;
    }
}