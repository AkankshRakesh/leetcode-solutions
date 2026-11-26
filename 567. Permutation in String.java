class Solution {
    public boolean check(int[] freq, int[] curr){
        for(int i = 0; i < 26; i++){
            int ind = i + 'a';
            if(freq[ind] < curr[ind]) return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[128];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i)]++;
        }

        int[] curr = new int[128];
        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            curr[s2.charAt(right)]++;

            while(!check(freq, curr)){
                curr[s2.charAt(left)]--;
                left++;
            }

            boolean foundFault = false;
            for(int i = 0; i < 26; i++){
                if(freq[i + 'a'] != curr[i + 'a']){
                    foundFault = true;
                    break;
                }
            }
            if(!foundFault) return true;
        }

        return false;
    }
}