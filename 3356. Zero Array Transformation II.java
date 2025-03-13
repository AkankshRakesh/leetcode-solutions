import java.util.*;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] line = new int[n + 1];

        for (int i = 0; i < k; i++) {
            line[queries[i][0]] += queries[i][2];
            if (queries[i][1] + 1 < n) {
                line[queries[i][1] + 1] -= queries[i][2];
            }
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += line[i];
            if (nums[i] > cur) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, r = queries.length + 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (isZeroArray(nums, queries, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l <= queries.length ? l : -1;
    }
}
