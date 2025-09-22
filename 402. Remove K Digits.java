class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        for(int i = 1; i < num.length(); i++){
            if(st.size() == 0){
                st.push(num.charAt(i));
                continue;
            }
            while(st.size() != 0 && st.peek() > num.charAt(i) && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        StringBuilder ans = new StringBuilder();
        boolean nonZeroFound = false;
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) == '0' && !nonZeroFound) continue;
            else{
                nonZeroFound = true;
                ans.append(sb.charAt(i));
            }
        }
        if(!nonZeroFound) return "0";

        return ans.toString();
    }
}