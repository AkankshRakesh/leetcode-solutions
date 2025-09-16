class Solution {
    class Pair{
        int num;
        int pow;
        public Pair(int num, int pow){
            this.num = num;
            this.pow = pow;
        }
    }
    public int backtrack(int[] dp, int n){
        if(n <= 1) return 0;

        int res;
        if(n % 2 == 0) res = n / 2;
        else res = (n * 3) + 1;
        
        if(dp[res] != -1) return dp[res];

        dp[res] = 1 + backtrack(dp, res);

        return dp[res];
    }
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.pow != b.pow ? Integer.compare(a.pow, b.pow) : Integer.compare(a.num, b.num));
        int[] dp = new int[10001];
        for(int i = 0; i < 10001; i++) dp[i] = -1;

        for(int i = lo; i <= hi; i++){
            int steps = 0;
            int n = i;
            while(n != 1){
                if(n % 2 == 0) n /= 2;
                else n = (n * 3) + 1;
                steps++;
            }
            // int steps = backtrack(dp, i);
            pq.offer(new Pair(i, steps));
        }

        k--;
        while(k > 0){
            k--;
            // System.out.println(pq.poll().pow);
            pq.poll();
        }
        return pq.poll().num;
    }
}