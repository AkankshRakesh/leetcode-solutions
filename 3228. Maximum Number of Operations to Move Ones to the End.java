class Solution {
    public int maxOperations(String s) {
        int moves = 0;
        int n = s.length();
        int ones=0;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') {
                ones++;
                flag = true;
            }
            if(s.charAt(i) == '0' && flag){
                moves += ones;
                flag = false;
            }
        }
        return moves;
    }
}