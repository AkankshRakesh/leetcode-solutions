class Solution {
    
    public int dfs(String word, char c1, char c2, int index, int[][][] dp){
        if(index >= word.length()) return 0;
        if(dp[c1 - 'A'][c2 - 'A'][index] != -1) return dp[c1 - 'A'][c2 - 'A'][index];

        int c1X = (c1 - 'A') % 6;
        int c1Y = (c1 - 'A') / 6;
        int c2X = (c2 - 'A') % 6;
        int c2Y = (c2 - 'A') / 6;
        int targetX = (word.charAt(index) - 'A') % 6;
        int targetY = (word.charAt(index) - 'A') / 6;
        int cost1 = Math.abs(targetX - c1X) + Math.abs(targetY - c1Y);
        int cost2 = Math.abs(targetX - c2X) + Math.abs(targetY - c2Y);
        int fingerA = cost1 + dfs(word, word.charAt(index), c2, index + 1, dp);
        int fingerB = cost2 + dfs(word, c1, word.charAt(index), index + 1, dp);

        return dp[c1 - 'A'][c2 - 'A'][index] = Math.min(fingerA, fingerB);
    }

    public void emptyDP(int[][][] dp){
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++) Arrays.fill(dp[i][j], -1);
        }
    }
    public int minimumDistance(String word) {
        int[][][] dp = new int[26][26][word.length()];

        int[] countChar = new int[26];
        for(int i = 0; i < word.length(); i++) countChar[word.charAt(i) - 'A']++;

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(countChar[i] == 0) continue;
            for(int j = i + 1; j < 26; j++){
                if(countChar[j] == 0) continue;
                emptyDP(dp);
                ans = Math.min(ans, dfs(word, (char)(i + 'A'), (char)(j + 'A'), 0, dp));
            }
        }

        return ans;
    }
}