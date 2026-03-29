class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] freqOddS1 = new int[26];
        int[] freqOddS2 = new int[26];
        int[] freqEvenS2 = new int[26];
        int[] freqEvenS1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            if(i % 2 == 0){
                freqEvenS1[s1.charAt(i) - 'a']++;
                freqEvenS2[s2.charAt(i) - 'a']++;
            }
            else{
                freqOddS1[s1.charAt(i) - 'a']++;
                freqOddS2[s2.charAt(i) - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(freqOddS1[i] != freqOddS2[i] || freqEvenS1[i] != freqEvenS2[i]) return false;
        }

        return true;
    }
}