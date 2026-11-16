class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() > k){
            StringBuilder sb1 = new StringBuilder();
            for(int i = 0; i < sb.length(); i += k){
                int dig = 0;
                for(int j = i; j < i + k && j < sb.length(); j++){
                    dig += sb.charAt(j) - '0';
                }
                sb1.append(dig);
            }
            sb = sb1;
        }

        return sb.toString();
    }
}