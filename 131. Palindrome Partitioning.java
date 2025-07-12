class Solution {
    public boolean isPalin(String s){
        int n = s.length();
        int left = 0, right = n - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public void backtracking(String s, List<List<String>> arr, ArrayList<String> currArr, int index, int n){
        if (index == n) {
            arr.add(new ArrayList<>(currArr));
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            String substr = s.substring(index, i);
            if (isPalin(substr)) {
                currArr.add(substr);
                backtracking(s, arr, currArr, i, n);
                currArr.remove(currArr.size() - 1); // backtrack
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> arr = new ArrayList<List<String>>();
        backtracking(s, arr, new ArrayList<String>(), 0, s.length());

        return arr;
    }
}