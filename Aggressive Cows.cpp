class Solution {
    public boolean check(int[] stalls, int gap, int target){
        int count = 1;
        int last = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= gap){
                last = stalls[i];
                count++;
            }
        }
        if(count >= target) return true;
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int right = stalls[stalls.length - 1] - stalls[0];
        int left = stalls[1] - stalls[0];
        for(int i = 2; i < stalls.length; i++) left = Math.min(left, stalls[i] - stalls[i - 1]);
        
        if(check(stalls, right, k)) return right;
        int ans = left;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(check(stalls,mid, k)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid;
        }
        
        return ans;
    }
}