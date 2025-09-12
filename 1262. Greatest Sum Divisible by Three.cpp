class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int twoC = 0, oneC = 0;
        int m = Integer.MAX_VALUE;
        int n = Integer.MAX_VALUE;
        int p = Integer.MAX_VALUE;
        int q = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                if (num < p) {
                    q = p;
                    p = num;
                } else if (num < q) {
                    q = num;
                }
            } else if (num % 3 == 2) {
                if (num < m) {
                    n = m;
                    m = num;
                } else if (num < n) {
                    n = num;
                }
            }
        }


        if(sum % 3 == 0) return sum;
        int ans = Integer.MIN_VALUE;
        if(m != Integer.MAX_VALUE && (sum - m) % 3 == 0) ans = Math.max(ans, sum - m);
        if(n != Integer.MAX_VALUE && (sum - n - m) % 3 == 0) ans = Math.max(ans, sum - n - m);
        if(p != Integer.MAX_VALUE && (sum - p) % 3 == 0) ans = Math.max(ans, sum - p);
        if(q != Integer.MAX_VALUE && (sum - p - q) % 3 == 0) ans = Math.max(ans, sum - p - q);

        return ans;
    }
}