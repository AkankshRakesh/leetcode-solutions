class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ns = new int[n];
        int[] ps = new int[n];
        Arrays.fill(ns, n);
        Arrays.fill(ps, -1);

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                ns[st.pop()] = i;
            }
            
            st.push(i);
        }
        st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                ps[st.pop()] = i;
            }
            
            st.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            // System.out.println(ns[i] + " " + ps[i]);
            ans = Math.max(ans, heights[i] * (ns[i] - ps[i] - 1));
        }

        return ans;
    }
} 