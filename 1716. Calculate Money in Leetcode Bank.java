class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int prevMonday = 1;
        int past = 0;
        for(int i = 0; i < n; i++){
            if(i % 7 == 0){
                ans += prevMonday;
                past = prevMonday;
                prevMonday++;
            }
            else{
                ans += past + 1;
                past++;
            }
        }

        return ans;
    }
}