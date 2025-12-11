class Solution {
    public static int LIS(ArrayList<int[]> arr){
        int[] dp = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) dp[i] = arr.get(i)[2];
        
        for(int i = 0; i < arr.size(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr.get(i)[0] > arr.get(j)[0] && arr.get(i)[1] > arr.get(j)[1]){
                    dp[i] = Math.max(dp[i], dp[j] + arr.get(i)[2]);
                }
            }
        }
        
        int ans = dp[0];
        for(int i = 1; i < arr.size(); i++) ans = Math.max(ans, dp[i]);
        
        return ans;
    }
    public static int maxHeight(int[] height, int[] width, int[] length) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0; i < height.length; i++){
            int h = height[i], w = width[i], l = length[i];
            arr.add(new int[]{h, w, l});
            arr.add(new int[]{h, l, w});
            arr.add(new int[]{l, h, w});
            arr.add(new int[]{l, w, h});
            arr.add(new int[]{w, l, h});
            arr.add(new int[]{w, h, l});
        }
        
        Collections.sort(arr, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        return LIS(arr);
    }
}