class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] last = st.peek();
            // System.out.println(last[0]);
            int[] curr = intervals[i];
            if(last[1] >= curr[0]){
                if(last[1] >= curr[1]) continue;
                else{
                    st.pop();
                    st.push(new int[]{last[0], curr[1]});
                }
            }
            else st.push(curr);
        }
        
        int[][] ans = new int[st.size()][2];
        int ind = 0;
        while(!st.isEmpty()){
            // System.out.println(st.peek()[0]);
            ans[ind++] = st.pop();   
        }

        return ans; 
    }
}