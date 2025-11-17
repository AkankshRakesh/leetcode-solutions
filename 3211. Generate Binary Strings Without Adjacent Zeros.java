class Solution {
    public void backtrack(List<String> ans, StringBuilder curr, boolean lastZero, int n){
        if(curr.length() == n){
            ans.add(curr.toString());
            return;
        }

        if(!lastZero){
            curr.append('0');
            backtrack(ans, curr, true, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        curr.append('1');
        backtrack(ans, curr, false, n);
        curr.deleteCharAt(curr.length() - 1);
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(),false, n);

        return ans;
    }
}