class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] track = new int[26];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] pattern = new int[26];
        int n = s.length(), m = p.length();
        if(m > n) return arr;

        for(int i = 0; i < m; i++){
            pattern[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < m && i < n; i++){
            track[s.charAt(i) - 'a']++;
        }
        boolean initial = true;
        for(int i = 0; i < 26; i++){
            if(track[i] != pattern[i]){
                initial = false;
                break;
            }
        }

        if(initial) arr.add(0);

        int left = 0;
        for(int i = m; i < n; i++){
            track[s.charAt(left) - 'a']--;
            left++;
            track[s.charAt(i) - 'a']++;
            boolean check = true;
            for(int j = 0; j < 26; j++){
                if(track[j] != pattern[j]){
                    check = false;
                    break;
                }
            }

            if(check) arr.add(left);
        }

        return arr;
    }
}