class Solution {
    int MOD = 1_000_000_007;
    public long findMaxProduct(List<Integer> arr) {
        if(arr.size() == 1) return arr.get(0);
        long prod = 1;
        long largestNeg = Integer.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        
        for(int num : arr){
            if(num == 0){
                countZero++;
                continue;
            }
            prod = (prod * num) % MOD;
            if(num < 0){
                countNeg++;
                if(num > largestNeg) largestNeg = num;
            }
        }
        
        if (countZero == arr.size()) return 0; 

        if (countNeg % 2 == 1) {
            prod /= largestNeg;
        }

        if (countNeg == 1 && countZero + countNeg == arr.size()) {
            return 0;
        }

        return ((prod % MOD) + MOD) % MOD;
    }
}