class Solution {
    public int minOperations(String s) {
        int zeroSt = 0, oneSt = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(i % 2 == 0){
                if(ch == '1') zeroSt++;
                else oneSt++;
            }
            else{
                if(ch == '0') zeroSt++;
                else oneSt++;
            }
        }

        return Math.min(oneSt, zeroSt);
    }
}