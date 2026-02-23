class Solution {
    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i = 0; i < nums.length; i++) ans[i] = Integer.toString(nums[i]);
        Arrays.sort(ans, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for(String curr : ans){
            sb.append(curr);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}