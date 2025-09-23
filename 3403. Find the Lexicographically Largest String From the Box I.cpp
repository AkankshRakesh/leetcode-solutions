class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;

        int maxLen = n - numFriends + 1;
        String ans = "";
        for (int i = 0; i < n; i++) {
            String candidate;
            if(i + maxLen <= word.length()) candidate = word.substring(i, i + maxLen);
            else candidate = word.substring(i);
            // System.out.println(candidate);
            if (ans.compareTo(candidate) < 0) ans = candidate;
        }
        return ans;
    }
}
