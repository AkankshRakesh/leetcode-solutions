class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] arr = new boolean[101];
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int num : nums){
            if(arr[num]){
                if(ans[0] != -1){
                    ans[1] = num;
                    break;
                }
                ans[0] = num;
            }
            arr[num] = true;
        }

        return ans;
    }
}