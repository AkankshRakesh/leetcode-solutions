class Solution {
    public boolean check(int num){
        while(num != 0){
            if(num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int first = n - 1;
        while(!check(first) || !check(n - first)) first--;

        return new int[]{first, n - first};
    }
}