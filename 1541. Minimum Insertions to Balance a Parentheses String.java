class Solution {
    public int minInsertions(String s) {
        int op = 0;
        int cl = 0;
        int ans = 0;
        int index = 0;
        
        while(index < s.length()){
            if(s.charAt(index) == ')'){
                if(index + 1 >= s.length() || s.charAt(index + 1) == '('){
                    if(op == 0){
                        ans += 2;
                    }
                    else{
                        ans++;
                        op--;
                    }
                    index++;
                }
                else{
                    if(op == 0) ans++;
                    else op--;
                    index += 2;
                }
            }
            else{
                op++;
                index++;
            }
        }
        
        return ans + op * 2;
    }
}