class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int ans = 0;
        for(int i = 1; i < colors.length(); i++){
            int top = st.peek();
            if(colors.charAt(top) == colors.charAt(i)){
                if(neededTime[top] > neededTime[i]){
                    ans += neededTime[i];
                }
                else{
                    ans += neededTime[st.pop()];
                    st.push(i);
                }
            }
            else st.push(i);
        }

        return ans;
    }
}