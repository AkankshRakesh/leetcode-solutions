/*Complete the function below*/
class GfG {
    public int remAnagrams(String s1, String s2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++) c1[s1.charAt(i) - 'a']++;
        for(int i = 0; i < s2.length(); i++) c2[s2.charAt(i) - 'a']++;
        
        int ans = 0;
        for(int i = 0; i < 26; i++) ans += Math.abs(c1[i] - c2[i]);
        
        return ans;
    }
}