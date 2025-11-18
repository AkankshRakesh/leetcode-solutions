class Solution {
    String ans;
    public boolean backtrack(StringBuilder curr, int len, HashSet<String> hs){
        if(curr.length() == len){
            if(!hs.contains(curr.toString())){
                ans = curr.toString();
                return true;
            }
            return false;
        }

        curr.append("0");
        boolean res = backtrack(curr, len, hs);
        curr.deleteCharAt(curr.length() - 1);
        if(res) return res;

        curr.append("1");
        res = backtrack(curr, len, hs);
        curr.deleteCharAt(curr.length() - 1);

        return res;
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();
        for(String s : nums) hs.add(s);

        backtrack(new StringBuilder(), nums[0].length(), hs);
        return ans;
    }
}