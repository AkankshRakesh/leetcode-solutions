class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n == 1){
            ans[0] = 0;
            return ans;
        }
        int ind = 0;
        if(n % 2 == 0){
            int temp = n;
            while(ind != n){
                ans[ind++] = temp;
                ans[ind++] = -temp;
                temp--;
            }
        }
        else{
            int temp = n;
            ans[ind++] = -temp;
            ans[ind++] = temp - 1;
            ans[ind++] = 1;
            temp -= 2;
            while(ind != n){
                ans[ind++] = temp;
                ans[ind++] = -temp;
                temp--;
            }
        }

        return ans;
    }
}