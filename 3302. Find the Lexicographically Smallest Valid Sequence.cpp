class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m];

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) break;

            suf[j] = i;
            i--;
        }

        int[] ans = new int[m];

        int p = 0;
        boolean mismatchUsed = false;

        for (i = 0; i < n && p < m; i++) {
            if (word1.charAt(i) == word2.charAt(p)) {
                ans[p++] = i;
            }
            else if (!mismatchUsed) {
                if (p == m - 1) {
                    ans[p++] = i;
                    mismatchUsed = true;
                }
                else if (i < suf[p + 1]) {
                    ans[p++] = i;
                    mismatchUsed = true;
                }
            }
        }

        return p == m ? ans : new int[]{};
    }
}