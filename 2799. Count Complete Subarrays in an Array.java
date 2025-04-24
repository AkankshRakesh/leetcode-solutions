class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] map = new int[2001];
        int n = nums.length;
        
        for(int num : nums) map[num]++;
        
        int distinct = 0;

        for(int i = 0; i < 2001; i++){
            if(map[i] != 0) distinct++;
            if(distinct == n) break;
        }
        map = new int[2001];
        int curr = 0;
        int right = 0;
        int res = 0;

        for(int left = 0; left < n; left++){
            if(left > 0){
                int removeEle = nums[left - 1];
                map[removeEle]--;
                if(map[removeEle] == 0)curr--;
            }
            while(right < n && curr < distinct){
                int add = nums[right];
                if(map[add] == 0) curr++;
                map[add]++;
                right++;
            }
            if(curr == distinct){
                res += (n - right + 1);
            }
        }
        return res;
    }
}