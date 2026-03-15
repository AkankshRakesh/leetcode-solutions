class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long[] prevSmallest = new long[n];
        long[] nextSmallest = new long[n];
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek()[0] > arr[i]) st.pop();
            if(st.isEmpty()) prevSmallest[i] = -1;
            else prevSmallest[i] = st.peek()[1];

            st.push(new int[]{arr[i], i});
        }
        st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek()[0] >= arr[i]) st.pop();
            if(st.isEmpty()) nextSmallest[i] = n;
            else nextSmallest[i] = st.peek()[1];

            st.push(new int[]{arr[i], i});
        }

        long ans = 0;
        int MOD = 1_000_000_007;
        for(int i = 0; i < n; i++){
            // System.out.println(prevSmallest[i] + " " + nextSmallest[i]);
            ans = (ans + (arr[i] * ((i - prevSmallest[i]) * (nextSmallest[i] - i))) % MOD) % MOD;
        }

        return (int)ans;
    }
}