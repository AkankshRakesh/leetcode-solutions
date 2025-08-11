class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int size = queries.length;
        int[] ans = new int[size];
        ArrayList<Integer> arr = new ArrayList<>();
        int ind = 0;
        while(n != 0){
            if((n & 1) == 1){
                arr.add((int)Math.pow(2, ind));
                // System.out.println(ind);
            }
            ind++;
            n = n >> 1;
        }

        for(int i = 0; i < size; i++){
            int lower = queries[i][0];
            int upper = queries[i][1];
            if(lower == upper) ans[i] = arr.get(lower);
            else{
                long prod = 1;
                for(int j = lower; j <= upper; j++){
                    prod = (prod * arr.get(j)) % 1_000_000_007;
                }

                ans[i] = (int)prod;
            }
        }

        return ans;
    }
}