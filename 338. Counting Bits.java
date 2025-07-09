class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;

        for(int i = 1; i <= n; i++){
            int bits = (int)(Math.log(i)/Math.log(2));
            int range = (int)Math.pow(2, bits);
            arr[i] = 1 + arr[i - range];
        }

        return arr;
    }
}