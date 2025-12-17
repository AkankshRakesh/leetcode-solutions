class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] dp = new int[arr.length];
        int[] parent = new int[arr.length];
        Arrays.fill(parent, -1);
        Arrays.fill(dp, 1);
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }
        int maxLen = 1;
        for(int val : dp) maxLen = Math.max(val, maxLen);
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(dp[i] == maxLen){
                int past = parent[i];
                st.push(arr[i]);
                while(past != -1){
                    st.push(arr[past]);
                    past = parent[past];
                }
                break;
            }
        }
        
        while(!st.isEmpty()) ans.add(st.pop());
        
        return ans;
    }
}
