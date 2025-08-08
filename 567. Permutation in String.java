class Solution {
    public boolean match(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < n; i++) arr1[s1.charAt(i) - 'a']++;
        for(int i = 0; i < n; i++) arr2[s2.charAt(i) - 'a']++;

        if(match(arr1, arr2)) return true;
        int left = 0;
        for(int i = n; i < m; i++){
            arr2[s2.charAt(left) - 'a']--;
            left++;
            arr2[s2.charAt(i) - 'a']++;
            if(match(arr1, arr2)) return true;
        }

        return false;
    }
}