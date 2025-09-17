class Solution {
    class Pair{
        Integer t;
        Integer ind;
        public Pair(Integer t, Integer ind){
            this.t = t;
            this.ind = ind;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(temp[0], 0));

        int[] ans = new int[temp.length];
        for(int i = 1; i < temp.length; i++){
            // int count = 0;
            while(!st.isEmpty() && temp[i] > st.peek().t){
                ans[st.peek().ind] = i - st.peek().ind;
                st.pop();
            }
            st.push(new Pair(temp[i], i));
        }

        return ans;
    }
}