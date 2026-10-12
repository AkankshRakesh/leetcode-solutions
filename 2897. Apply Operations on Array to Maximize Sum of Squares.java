class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for(int num : nums){
            int index = 0;
            while(num != 0){
                if(num % 2 == 1) count[index]++;
                num /= 2;
                index++;
            }
        }

        long ans = 0;
        for(int i = 0; i < k; i++){
            long curr = 0;
            for(int j = 31; j >= 0; j--){
                if(count[j] != 0){
                    count[j]--;
                    curr = curr | (1 << j);
                    // System.out.println(1 << j);
                }
            }

            curr = (curr * curr) % 1_000_000_007;

            ans = (ans + curr) % 1_000_000_007;
        }

        return (int)ans;
    }
}