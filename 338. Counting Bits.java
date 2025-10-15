class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int count = 0;
            int num = i;
            // System.out.println(num);
            for(int j = 0; j < 32; j++){
                count += (num & 1);
                num = num >> 1;
            }
            ans[i] = count;
        }

        return ans;
    }
}