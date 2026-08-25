class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        for(int num : nums){
            seen.add(num);
        }
        
        int num = k;
        while(seen.contains(num)){
            num += k;
        }

        return num;
    }
}