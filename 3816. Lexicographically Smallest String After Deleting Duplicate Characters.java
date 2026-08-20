class Solution {
    public String lexSmallestAfterDeletion(String s) {
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++;
        }

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            while(st.size() > 0 && st.peek() > s.charAt(i) && freq[st.peek()] > 1){
                freq[st.peek()]--;
                st.pop();
            }
            st.push(s.charAt(i));
        }

        char dup = st.peek();
        while(st.size() > 0 && freq[st.peek()] > 1){
            freq[st.peek()]--;
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString(); 
    }
}