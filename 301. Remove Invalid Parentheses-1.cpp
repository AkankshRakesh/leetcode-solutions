class Solution {
    public boolean isValid(String s){
        int op = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')') op--;
            else if(s.charAt(i) == '(') op++;

            if(op < 0) return false;
        }
        
        return op == 0;
    }
    public void dfs(String s, int index, StringBuilder sb, int deletions, HashSet<String> hs){
        if(index >= s.length() || deletions == 0){
            StringBuilder currSb = new StringBuilder(sb);
            for(int i = index; i < s.length(); i++) currSb.append(s.charAt(i));
            
            String currS = currSb.toString();
            if(isValid(currS) && !hs.contains(currS)) hs.add(currS);

            return;
        }

        if(s.charAt(index) == '(' || s.charAt(index) == ')'){
            dfs(s, index + 1, sb, deletions - 1, hs);

            sb.append(s.charAt(index));
            dfs(s, index + 1, sb, deletions, hs);
            sb.deleteCharAt(sb.length() - 1);
        }
        else{
            sb.append(s.charAt(index));
            dfs(s, index + 1, sb, deletions, hs);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int op = 0;
        int deletions = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') op++;
            else if(s.charAt(i) == ')') op--;

            if(op < 0){
                op = 0;
                deletions++;
            }
        }

        deletions += op;

        // System.out.println(deletions);

        HashSet<String> hs = new HashSet<>();
        dfs(s, 0, new StringBuilder(), deletions, hs);

        List<String> ans = new ArrayList<>();
        for(String str : hs) ans.add(str);

        return ans;
    }
}