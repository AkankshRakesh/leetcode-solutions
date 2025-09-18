class Solution {
    // public void seive(boolean[] si){
    //     for(int i = 2; i * i <= 1009; i++){
    //         if(si[i]){
    //             for(int j = i * i; j < 1009; j++) si[j] = false;
    //         }
    //     }
    // }
    public int distinctPrimeFactors(int[] nums) {
        // boolean[] si = new boolean[1010];
        // seive(si);
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0){
                    hs.add(i);
                    while(num % i == 0) num /= i;
                }
            }
            if(num > 1) hs.add(num);
        }

        return hs.size();
    }
}