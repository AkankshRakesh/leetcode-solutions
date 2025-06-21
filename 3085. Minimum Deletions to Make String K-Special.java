class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freqTable = new int[26];
        int n = word.length();

        for(int i = 0; i < n; i++) freqTable[word.charAt(i) - 'a']++;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(freqTable[i] == 0) continue;
            
            int upperRange = freqTable[i] + k;
            int deleted = 0;
            for(int j = 0; j < 26; j++){
                if(i == j) continue;
                if(freqTable[j] < freqTable[i]) deleted += freqTable[j];
                else if(freqTable[j] > upperRange) deleted += (freqTable[j] - upperRange);
            }

            if(min > deleted) min = deleted;
        }
        
        return min;
    }
}