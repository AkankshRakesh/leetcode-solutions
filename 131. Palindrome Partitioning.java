class Solution {
    public boolean palindrome(String s){
        int len = s.length();
        for(int i = 0; i <= len / 2; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }

        return true;
    }
    public void backtrack(String s, int index, List<List<String>> ans, HashSet<String> acceptedHs, ArrayList<String> currArr,StringBuilder curr){
        int len = s.length();
        if(index >= len){
            if(curr.length() == 0) ans.add(new ArrayList<>(currArr));
            return;
        }

        curr.append(s.charAt(index));
        boolean isPalin = false;
        if(acceptedHs.contains(curr.toString()) || palindrome(curr.toString())){
            isPalin = true;
            currArr.add(curr.toString());
            acceptedHs.add(curr.toString());
            backtrack(s, index + 1, ans, acceptedHs, currArr, new StringBuilder(""));
        }
        // curr.deleteCharAt(curr.length() - 1);
        if(isPalin) currArr.remove(currArr.size() - 1);
        backtrack(s, index + 1, ans, acceptedHs, currArr, curr);
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> acceptedHs = new HashSet<>();
        backtrack(s, 0, ans, acceptedHs, new ArrayList<>(), new StringBuilder());

        return ans;
    }
}