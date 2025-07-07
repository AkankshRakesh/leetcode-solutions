class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
            char top = stack.peek();
            if((top == 'D' || top == 'B') && stack.size() >= 2){
                char topEle = stack.pop();
                char secondTop = stack.peek();
                if((top == 'D' && secondTop == 'C') || (top == 'B' && secondTop == 'A')) stack.pop();
                else stack.push(topEle);
            }
        }
        return stack.size();
    }
}