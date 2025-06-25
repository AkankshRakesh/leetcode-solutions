class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int num: nums){
            if(hm.get(num) != null) return true;
            hm.put(num, 0);
        }

        return false;
    }
}