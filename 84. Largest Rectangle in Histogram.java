class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[][] dp = new int[heights.length][2];
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            if(!st.isEmpty()) dp[i][0] = st.peek();
            else dp[i][0] = -1;

            st.push(i);
        }
        st = new Stack<>();

        for(int i = heights.length - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

            if(!st.isEmpty()) dp[i][1] = st.peek();
            else dp[i][1] = heights.length;

            st.push(i);
        }

        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            ans = Math.max(ans, (dp[i][1] - dp[i][0] - 1) * heights[i]);
        }

        return ans;
    }
}