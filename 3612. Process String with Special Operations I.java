class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();

        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                sb.append(ch);
            }
            else if(ch == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if(ch == '#'){
                if(sb.length() > 0){
                    sb.append(sb.toString());
                }
            }
            else{
                sb.reverse();
            }
        }

        return sb.toString();
    }
}