class Solution {
public:
    int dfs(string s, int left, int right) {
        if (left >= right) return 0;

        int sum = 0;
        int i = left;

        while (i < right) {
            int curr = 1;
            int next = i + 1;

            while (next < right && curr != 0) {
                if (s[next] == '(') curr++;
                else curr--;
                next++;
            }

            int insideSum = dfs(s, i + 1, next - 1);

            if (insideSum == 0) sum++;
            else sum += 2 * insideSum;

            i = next;
        }

        return sum;
    }

    int scoreOfParentheses(string s) {
        return dfs(s, 0, s.length());
    }
};