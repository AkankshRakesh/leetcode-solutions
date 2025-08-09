class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i = 0; i < n; i++){
            if(tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")){
                int top = stack.pop();
                int secondTop = stack.pop();
                switch(tokens[i]){
                    case "/":
                        secondTop /= top;
                        break;
                    case "*":
                        secondTop *= top;
                        break;
                    case "+":
                        secondTop += top;
                        break;
                    case "-":
                        secondTop -= top;
                        break;
                }
                stack.push(secondTop);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}