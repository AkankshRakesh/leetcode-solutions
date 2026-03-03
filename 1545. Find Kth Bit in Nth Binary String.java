class Solution {
    public char findKthBit(int n, int k) {
        boolean flip = false;
        k--;
        while(n != 1){
            long total = (long)Math.pow(2, n) - 1;
            long mid = total / 2;
            if(k == mid){
                if(!flip) return '1';
                return '0';
            }
            else if(k > mid){
                k = (int)(total - k - 1);
                flip = !flip;
            }
            // System.out.println(k);
            n--;
        }
        
        if(flip) return '1';
        return '0';
    }
}