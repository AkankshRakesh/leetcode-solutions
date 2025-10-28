class Solution {
    public boolean check(char top, char curr){
        if((top == '(' && curr == ')') || (top == '[' && curr == ']') || (top == '{' && curr == '}'))
            return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            char top = st.peek();
            if(check(top, ch)) st.pop();
            else st.push(ch);
        }

        if(st.size() != 0) return false;
        return true;
    }
}