class Solution {
    class Pair {
        char ch;
        int num;

        Pair(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(stack.size() >= 1 && ch == stack.peek().ch){
                int count = stack.pop().num;
                stack.push(new Pair(ch, count + 1));
            }
            else{
                stack.push(new Pair(ch, 1));
            }

            while(stack.size() >= 1 && stack.peek().num >= k){
                char topCh = stack.peek().ch;
                int count = stack.pop().num;
                if(count != k){
                    stack.push(new Pair(topCh, count - k));
                }
            }
        }
        String ans = "";
        for(int i = 0; i < stack.size(); i++){
            Pair ele = stack.elementAt(i);
            for(int j = 0; j < ele.num; j++) ans += ele.ch;
        }

        return ans;
    }
}