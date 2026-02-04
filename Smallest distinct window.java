// User function Template for Java

class Solution {
    public int findSubString(String s) {
        int[] freq = new int[128];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i)] == 0) count++;
            freq[s.charAt(i)]++;
        }
        
        int left = 0;
        int ans = s.length();
        int[] currFreq = new int[128];
        for(int right = 0; right < s.length(); right++){
            if(currFreq[s.charAt(right)] == 0) count--;
            currFreq[s.charAt(right)]++;
            
            while(count == 0){
                
                ans = Math.min(ans, right - left + 1);
                if(currFreq[s.charAt(left)] == 1) count++;
                currFreq[s.charAt(left)]--;
                left++;
            }
        }
        
        return ans;
    }
}