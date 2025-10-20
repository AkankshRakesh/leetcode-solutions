class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String opt : operations){
            if(opt.charAt(0) == '-' || opt.charAt(2) == '-') x--;
            else x++;
        } 

        return x;
    }
}