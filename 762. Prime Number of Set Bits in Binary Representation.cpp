class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            int temp = i;
            int setBits = 0;
            while(temp != 0){
                setBits += (temp & 1);
                temp = temp >> 1;
            }
            switch(setBits){
                case 2: case 3: case 5: case 7: case 11: case 13: case 17: case 19: case 23: case 29: case 31:
                count++;
            }
        }
        return count;
    }
}