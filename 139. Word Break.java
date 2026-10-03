class Solution {
    public boolean dfs(String s, int index, HashSet<String> hs, Boolean[] dp){
        if(index >= s.length()) return true;

        if(dp[index] != null) return dp[index];

        StringBuilder sb = new StringBuilder();
        boolean res = false;
        for(int i = index; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(hs.contains(sb.toString())) res |= dfs(s, i + 1, hs, dp);
        }

        return dp[index] = res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String word : wordDict) hs.add(word);
        Boolean[] dp = new Boolean[s.length()];
        
        return dfs(s, 0, hs, dp);
    }
}