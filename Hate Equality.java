public class Solution {
    static int canYouMakeDifference(int n, String s) {
        char ch = s.charAt(0);
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != ch) return 1;
        }

        return 0;
    }
}