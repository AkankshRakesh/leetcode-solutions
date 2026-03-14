class Solution {
    public boolean check(String word1, String word2, int len1, int len2){
        int i = 0, j = 0;
        boolean found = false;
        while(i < len1 && j < len2){
            if(word1.charAt(i) != word2.charAt(j)){
                if(found) return false;
                found = true;
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        
        return true;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            // System.out.print(words[i] + " ");
            for(int j = i - 1; j >= 0; j--){
                String word1 = words[i];
                String word2 = words[j];
                int len1 = word1.length();
                int len2 = word2.length();
                if(len2 + 1 == len1 && check(word1, word2, len1, len2)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // System.out.println(words[i] + " " + dp[i]);
        }

        int ans = 1;
        for(int dpVal: dp) ans = Math.max(ans, dpVal);

        return ans;
    }
}