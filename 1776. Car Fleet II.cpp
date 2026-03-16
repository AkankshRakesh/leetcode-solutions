class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty()){
                if(cars[st.peek()][1] >= cars[i][1]) st.pop();
                else{
                    double collisionTime = ((double)(cars[st.peek()][0] - cars[i][0])) / ((double)(cars[i][1] - cars[st.peek()][1]));
                    if(ans[st.peek()] == -1 || ans[st.peek()] > collisionTime){
                        ans[i] = collisionTime;
                        break;
                    }
                    else st.pop();
                }
            }
            st.push(i);
        }

        return ans;
    }
}