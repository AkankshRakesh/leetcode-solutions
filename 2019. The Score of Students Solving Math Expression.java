class Solution {
    public HashSet<Integer> dfs(String s, int left, int right, HashSet<Integer>[][] dp){
        if(left == right){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(s.charAt(left) - '0');
            return hs;
        }

        if(dp[left][right] != null) return dp[left][right];

        HashSet<Integer> hs = new HashSet<>();
        for(int i = left; i <= right; i++){
            if(s.charAt(i) == '*' || s.charAt(i) == '+'){
                HashSet<Integer> l = dfs(s, left, i - 1, dp);
                HashSet<Integer> r = dfs(s, i + 1, right, dp);

                for(int ele1 : l) {
                    for(int ele2 : r) {

                        int val;

                        if(s.charAt(i) == '*')
                            val = ele1 * ele2;
                        else
                            val = ele1 + ele2;

                        if(val <= 1000)
                            hs.add(val);
                    }
                }
            }
        }

        return dp[left][right] = hs;
    }
    public int scoreOfStudents(String s, int[] answers) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                st.push(st.pop() * (s.charAt(i + 1) - '0'));
                i++;
            }
            else if(s.charAt(i) == '+'){
                st.push(s.charAt(i + 1) - '0');
                i++;
            }
            else st.push(s.charAt(i) - '0');
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }

        HashSet<Integer>[][] dp = new HashSet[s.length()][s.length()];
        HashSet<Integer> wAns = dfs(s, 0, s.length() - 1, dp);

        int score = 0;
        for(int answer : answers){
            if(answer == ans) score += 5;
            else if(wAns.contains(answer)) score += 2;
        }

        return score;
    }
}