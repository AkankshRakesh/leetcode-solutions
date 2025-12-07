class Solution {
    public boolean overlaps(int[] a, int[] b){
        if(a[1] >= b[0] && a[0] <= b[1]) return true;
        return false;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval}; 
        Stack<int[]> st = new Stack<>();
        boolean added = false;
        for(int i = 0; i < intervals.length; i++){
            if(st.isEmpty()) st.push(intervals[i]);
            else if(!added && overlaps(st.peek(), newInterval)){
                int[] a = st.pop();
                int[] combined = new int[2];
                combined[0] = Math.min(a[0], newInterval[0]);
                combined[1] = Math.max(a[1], newInterval[1]);
                st.push(combined);
                i--;
                added = true;
            }
            else if(!added && newInterval[0] < st.peek()[0]){
                int[] a = st.pop();
                st.push(newInterval);
                st.push(a);
                added = true;
                i--;
            } 
            else if(overlaps(st.peek(), intervals[i])){
                int[] a = st.pop();
                int[] combined = new int[2];
                combined[0] = Math.min(a[0], intervals[i][0]);
                combined[1] = Math.max(a[1], intervals[i][1]);
                st.push(combined);
            }
            else st.push(intervals[i]);
        }
        
        if(!added && overlaps(st.peek(), newInterval)){
            int[] a = st.pop();
            int[] combined = new int[2];
            combined[0] = Math.min(a[0], newInterval[0]);
            combined[1] = Math.max(a[1], newInterval[1]);
            st.push(combined);
        }
        else if(!added && newInterval[0] < st.peek()[0]){
            int[] a = st.pop();
            st.push(newInterval);
            st.push(a);
            added = true;
        } 
        else if(!added) st.push(newInterval);


        int[][] ans = new int[st.size()][2];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}