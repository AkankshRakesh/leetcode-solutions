class Solution {
    public boolean dfs(String s, int index, HashSet<String> words, Boolean[] dp){
        if(index == s.length()) return true;
        boolean res = false;
        StringBuilder sb = new StringBuilder();
        if(dp[index] != null) return dp[index];

        for(int i = index; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(words.contains(sb.toString())) res |= dfs(s, i + 1, words, dp);
            if(res) break;
        }

        return dp[index] = res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>();
        Boolean[] dp = new Boolean[s.length()];
        for(String word : wordDict) words.add(word);

        return dfs(s, 0, words, dp);
    }
}