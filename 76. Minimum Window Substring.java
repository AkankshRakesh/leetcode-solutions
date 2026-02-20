class Solution {
    public String minWindow(String s, String t) {
        int[] ansFreq = new int[128];
        int ansCount = 0;
        for(int i = 0; i < t.length(); i++){
            if(ansFreq[t.charAt(i)] == 0) ansCount++;
            ansFreq[t.charAt(i)]++;
        }
        
        int[] freq = new int[128];
        int count = 0;
        String ans = new String(s);
        int left = 0;
        StringBuilder sb = new StringBuilder();
        boolean oneMatch = false;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]++;
            if(freq[s.charAt(right)] == ansFreq[s.charAt(right)]) count++;
            // sb.append(s.charAt(i));

            while(count == ansCount){
                oneMatch = true;
                if(right - left + 1 < ans.length()){
                    ans = s.substring(left, right + 1);
                }
                if(freq[s.charAt(left)] == ansFreq[s.charAt(left)]) count--;
                freq[s.charAt(left)]--;
                left++;
            }
        }

        if(!oneMatch) return "";
        return ans;
    }
}