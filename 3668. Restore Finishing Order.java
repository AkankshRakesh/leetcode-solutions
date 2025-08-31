class Solution {
    public int[] recoverOrder(int[] orders, int[] friends) {
        int[] ans = new int[friends.length];
        int ind = 0;
        for(int order: orders){
            for(int i = 0; i < friends.length; i++){
                if(order == friends[i]){
                    ans[ind] = order;
                    friends[i] = -1;
                    ind++;
                    break;
                }
            }
        }
        return ans;
    }
}