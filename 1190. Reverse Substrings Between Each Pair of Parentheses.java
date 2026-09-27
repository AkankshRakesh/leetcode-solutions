class Solution {
    public StringBuilder solve(String s, int[] index) {
        StringBuilder sb = new StringBuilder();

        while (index[0] < s.length() && s.charAt(index[0]) != ')') {
            if (s.charAt(index[0]) == '(') {
                index[0]++;
                sb.append(solve(s, index));
            } else {
                sb.append(s.charAt(index[0]));
                index[0]++;
            }
        }

        index[0]++;
        return sb.reverse();
    }

    public String reverseParentheses(String s) {
        StringBuilder ans = solve(s, new int[]{0});
        return ans.reverse().toString();
    }
}