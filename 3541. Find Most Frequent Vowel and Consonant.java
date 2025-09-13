class Solution {
    public boolean isVowel(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int maxVowel = 0, maxCons = 0;
        for(int i = 0; i < 26; i++){
            if(isVowel((char)(i + 97))) maxVowel = Math.max(maxVowel, freq[i]);
            else maxCons = Math.max(maxCons, freq[i]);
        }

        return maxVowel + maxCons;
    }
}