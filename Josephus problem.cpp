class Solution {
    public int josephus(int n, int k) {
        boolean[] dead = new boolean[n];
        int count = n;
        int index = 0;
        int eleCount = 0;
        
        while(count > 1){
            index = 0;
            while(index < n){
                if(!dead[index]) eleCount++;
                if(eleCount >= k){
                    // System.out.println(index);
                    dead[index] = true;
                    eleCount = 0;
                    count--;
                    if(count == 1) break;
                }
                index++;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!dead[i]) return i + 1;
        }
        
        return -1;
    }
}