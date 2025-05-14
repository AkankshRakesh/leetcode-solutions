class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, 0);
        for(int num : nums){
            int currCount = map.get(num);
            map.put(num, currCount+1);
        }

        int[] ans = new int[2];
        boolean next = false;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() == 1){
                if(!next){ 
                    ans[0] = e.getKey();
                    next = !next;
                }
                else{
                    ans[1] = e.getKey();
                    break;
                }
            }
        }
        return ans;
    }
}