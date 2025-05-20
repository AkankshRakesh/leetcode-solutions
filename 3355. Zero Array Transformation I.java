public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int li = query[0];
            int ri = query[1];
            diff[li]--;
            if (ri + 1 < n) {
                diff[ri + 1]++;
            }
        }

        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i];
            nums[i] += currentDecrement;

            if (nums[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
