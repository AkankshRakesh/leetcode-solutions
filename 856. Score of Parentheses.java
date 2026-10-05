class Solution {
    public int dfs(String s, int left, int right){
        if(left >= right) return 0;
        int sum = 0;
        int i = left;

        while (i < right) {
            int curr = 1;
            int next = i + 1;
            while(next < right && curr != 0){
                if(s.charAt(next) == '(') curr++;
                else curr--;
                next++;
            }

            int insideSum = dfs(s, i + 1, next - 1);
            if(insideSum == 0) sum++;
            else sum += 2 * insideSum;
            
            i = next;
        }

        return sum;
    }
    public int scoreOfParentheses(String s) {
        return dfs(s, 0, s.length());
    }
}