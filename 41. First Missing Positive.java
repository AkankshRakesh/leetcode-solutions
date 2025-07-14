class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums) if(num > 0) hs.add(num);

        for(int i = 1; i < Integer.MAX_VALUE; i++){
            if(!hs.contains(i)) return i;
        }
        return 0;
    }
}