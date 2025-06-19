class Solution {
    public int evenExpansion(String s, int ind, int n){
        int left = ind;
        int right = ind + 1;
        int ans = 0;

        while(left >= 0 && right < n){
            if(s.charAt(left) != s.charAt(right)) break;
            ans++;
            left--;
            right++;
        }
        return ans;
    }

    public int oddExpansion(String s, int ind, int n){
        int left = ind - 1;
        int right = ind + 1;
        int ans = 0;
        
        while(left >= 0 && right < n){
            if(s.charAt(left) != s.charAt(right)) break;
            ans++;
            left--;
            right++;
        }
        return ans;
    }
    public int countSubstrings(String s) {
        int n = s.length();

        int ans = n;
        for(int i = 0; i < n; i++){
            if(i != n - 1){
                ans += evenExpansion(s, i, n);
                if(i != 0) ans += oddExpansion(s, i, n);
            }
        }
        return ans;
    }
}
