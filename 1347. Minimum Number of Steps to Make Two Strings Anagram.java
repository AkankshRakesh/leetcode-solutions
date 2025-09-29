class Solution {
    public int minSteps(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        for(char ch : s.toCharArray()) countS[ch - 'a']++;
        int ans = 0;
        for(char ch : t.toCharArray()) countT[ch - 'a']++;
        for(int i = 0; i < 26; i++){
            if(countT[i] < countS[i]) ans += countS[i] - countT[i];
        }

        return ans;
    }
}