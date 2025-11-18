class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int ind = 0;
        while(ind < bits.length){
            if(bits[ind] == 0){
                ind++;
                if(ind == bits.length) return true;
            }
            else{
                ind += 2;
                if(ind >= bits.length) return false;
            }
        }
        return false;
    }
}