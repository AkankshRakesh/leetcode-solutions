class Solution {
    // public boolean check(String s){
    //     int score = 0;
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i) == '(') score++;
    //         else score--;

    //         if(score < 0) return false;
    //     }
    //     return true;
    // }
    public void backtrack(int open, int close, StringBuilder sb, int n, List<String> arr){
        if(sb.length() == n * 2){
            arr.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(open + 1, close, sb, n, arr);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(open, close + 1, sb, n, arr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        backtrack(0, 0, new StringBuilder(), n, arr);

        return arr;
    }
}