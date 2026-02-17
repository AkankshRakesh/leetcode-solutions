class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int currTemp = temperatures[i];
            while(!st.isEmpty() && st.peek()[0] < currTemp){
                int index = st.pop()[1];
                ans[index] = i - index;
            }
            st.push(new int[]{currTemp, i});
        }

        return ans;
    }
}