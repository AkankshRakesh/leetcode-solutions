class Solution {
    public int value(char ch){
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        
        return 1000;
    }
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(i + 1 < n){
                int beforeAns = ans;
                if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') ans += 4;
                else if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') ans += 9;
                else if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') ans += 40;
                else if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') ans += 90;
                else if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') ans += 400;
                else if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') ans += 900;
                
                if(ans == beforeAns) ans += value(s.charAt(i));
                else i++;
            }
            else ans += value(s.charAt(i));
        }
        
        return ans;
    }
}