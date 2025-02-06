class Solution {
    public long nCr(int n, int r) {
        if (r > n) return 0;
        return fact(n) / (fact(r) * fact(n - r));
    }

    public long fact(int n) {
        if (n == 0) return 1;
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public int tupleSameProduct(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                ans.add(product);
            }
        }

        Collections.sort(ans);

        int stored = ans.get(0), tempCount = 1;
        for (int i = 1; i < ans.size(); i++) {
            if (stored == ans.get(i)) {
                tempCount++;
            } else {
                if (tempCount > 1) {
                    count += nCr(tempCount, 2);
                }
                tempCount = 1;
                stored = ans.get(i);
            }
        }

        if (tempCount > 1) {
            count += nCr(tempCount, 2);
        }

        return count * 8;
    }

}
