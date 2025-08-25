class Solution {
    int i = 0;
    public StringBuilder dfs(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int times = 0;

        while(i < n){
            if(s.charAt(i) == '[') {
                i++;
                StringBuilder res = new StringBuilder(dfs(s));
                while(times != 0){
                    sb.append(res);
                    times--;
                }
                times = 0;
            }
            else if(s.charAt(i) == ']'){
                i++;
                return sb;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                times *= 10;
                times += (s.charAt(i) - '0');
                i++;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb;
    }
    public String decodeString(String s) {
        return dfs(s).toString();
    }
}