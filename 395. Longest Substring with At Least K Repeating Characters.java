class Solution {
    public int longestSubstring(String s, int k) {
        boolean[] found = new boolean[26];
        for(int i = 0; i < s.length(); i++) found[s.charAt(i) - 'a'] = true;
        int maxUnique = 0;
        for(int i = 0; i < 26; i++) if(found[i]) maxUnique++;
        int ans = 0;

        for(int uniqueLimit = 0; uniqueLimit <= maxUnique; uniqueLimit++){
            int[] freq = new int[26];
            int left = 0, countUnique = 0, countForK = 0;

            for(int right = 0; right < s.length(); right++){
                if(freq[s.charAt(right) - 'a'] == 0) countUnique++;
                freq[s.charAt(right) - 'a']++;

                while(countUnique > uniqueLimit){
                    freq[s.charAt(left) - 'a']--;
                    if(freq[s.charAt(left) - 'a'] == 0) countUnique--;
                    left++;
                }

                if(countUnique == uniqueLimit){
                    boolean valid = true;
                    for(int i = 0; i < 26; i++){
                        if(freq[i] != 0 && freq[i] < k){
                            valid = false;
                            break;
                        }
                    }
                    if(valid) ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
}