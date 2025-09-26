class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        int count = 0;
        for(Map.Entry<Integer, Integer> ele : hm.entrySet()){
            int num = ele.getKey();
            if(k == 0){
                if(hm.get(num) > 1) count++;
            }
            else if(hm.containsKey(k + num)) count++;
        }

        return count;
    }
}