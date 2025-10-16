class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remArr = new int[value];
        for(int num : nums){
            if(num < 0){
                int rem = -num % value;
                remArr[(value - rem) % value]++;
            }
            else remArr[num % value]++;
        }

        int ans = 0;
        while(remArr[ans % value] > 0){
            remArr[ans % value]--;
            ans++;
        }

        return ans;
    }
}