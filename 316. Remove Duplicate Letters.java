class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastInd = new int[26];
        for(int i = 0; i < s.length(); i++) lastInd[s.charAt(i) - 'a'] = i;

        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(seen[ch - 'a']) continue;

            while(!st.isEmpty() && ch < st.peek() && lastInd[st.peek() - 'a'] > i){
                seen[st.pop() - 'a'] = false;
            }

            st.push(ch);
            seen[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}