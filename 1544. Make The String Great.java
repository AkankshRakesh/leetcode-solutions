class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
            char top = stack.pop();
            
            if(stack.size() >= 1){
                char secondTop = stack.peek();
                if(top - 'A' >= 0 && top - 'A' <= 26){
                    if(secondTop - 'a' >= 0 && secondTop - 'a' <= 26){
                        if(top - 'A' == secondTop - 'a') stack.pop();
                        else stack.push(top);
                    }
                    else stack.push(top);
                }
                else{
                    if(secondTop - 'A' >= 0 && secondTop - 'A' <= 26){
                        if(top - 'a' == secondTop - 'A') stack.pop();
                        else stack.push(top);
                    }
                    else stack.push(top);
                }
            }
            else stack.push(top);
        }

        StringBuilder ans = new StringBuilder("");
        while(!stack.isEmpty()) ans.append(stack.pop());

        return ans.reverse().toString();
    }
}