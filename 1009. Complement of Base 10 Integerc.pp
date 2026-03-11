class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        
        int[] arrAns = new int[32];
        int index = 0;
        while(n != 0){
            int bit = n & 1;
            n = n >> 1;
            if(bit == 0) arrAns[index] = 1;
            index++; 
        }
        int ans = 0;
        System.out.println(index);
        for(int i = index - 1; i >= 0; i--){
            ans = ans << 1;
            ans = ans | arrAns[i];
        }

        return ans;
    }
}