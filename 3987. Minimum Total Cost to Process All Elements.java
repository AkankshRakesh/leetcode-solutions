import java.math.BigInteger;

class Solution {

    public boolean possible(int[] nums, int k, BigInteger cost) {
        long resources = k;
        long operations = 0;

        for (int num : nums) {
            if (resources < num) {
                long need = num - resources;
                long ops = (need + k - 1L) / k;

                operations += ops;

                resources += ops * k;
            }

            resources -= num;
        }

        BigInteger totalCost =
                BigInteger.valueOf(operations)
                          .multiply(BigInteger.valueOf(operations + 1))
                          .divide(BigInteger.TWO);

        return totalCost.compareTo(cost) <= 0;
    }

    public int minimumCost(int[] nums, int k) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        long maxOperations = (sum + k - 1L) / k - 1;

        BigInteger left = BigInteger.ZERO;

        BigInteger right =
                BigInteger.valueOf(maxOperations)
                          .multiply(BigInteger.valueOf(maxOperations + 1))
                          .divide(BigInteger.TWO);

        BigInteger ans = right;

        while (left.compareTo(right) <= 0) {
            BigInteger mid =
                    left.add(right)
                         .divide(BigInteger.TWO);

            if (possible(nums, k, mid)) {
                ans = mid;
                right = mid.subtract(BigInteger.ONE);
            } else {
                left = mid.add(BigInteger.ONE);
            }
        }

        return ans
                .mod(BigInteger.valueOf(1_000_000_007L))
                .intValue();
    }
}