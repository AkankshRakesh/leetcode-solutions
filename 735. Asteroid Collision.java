class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids){
            if(st.isEmpty() || asteroid > 0) st.push(asteroid);
            else{
                boolean destroyed = false;
                while(!st.isEmpty() && st.peek() > 0 && st.peek() <= (0 - asteroid)){
                    if(st.peek() == (0 - asteroid)){
                        st.pop();
                        destroyed = true;
                        break;
                    }
                    st.pop();
                }
                if(!destroyed && (st.isEmpty() || st.peek() < 0)) st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--) ans[i] = st.pop();

        return ans;
    }
}