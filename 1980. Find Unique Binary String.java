class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        int n = nums.length;
        int index = 0;
        for(String num : nums){
            if(num.charAt(index) == '0') ans.append('1');
            else ans.append('0');

            index++;
        }

        return ans.toString();
    }
}