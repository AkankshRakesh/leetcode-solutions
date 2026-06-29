class Solution {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (check(pattern, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String pattern, String word) {
        int m = pattern.length();
        int n = word.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (word.charAt(i + j) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}