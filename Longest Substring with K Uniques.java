class Solution {
    public int longestKSubstr(String s, int k) {
        int count = 0;
        int len = -1;
        int left = 0;
        
        int[] freq = new int[128];
        for(int right = 0; right < s.length(); right++){
            if(freq[s.charAt(right)] == 0) count++;
            freq[s.charAt(right)]++;
            
            while(count > k){
                // len = Math.max(len, right - left + 1);
                
                if(freq[s.charAt(left)] == 1) count--;
                freq[s.charAt(left)]--;
                left++;
            }
            if(count == k) len = Math.max(len, right - left + 1);
        }
        
        if(count == k) len = Math.max(len, s.length() - left);
        
        return len;
    }
}