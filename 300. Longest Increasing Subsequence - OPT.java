class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            if(arr.size() == 0 || arr.get(arr.size() - 1) < num) arr.add(num);
            else{
                int left = 0, right = arr.size() - 1;
                int ans = 0;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(arr.get(mid) < num) left = mid + 1;
                    else{
                        ans = mid;
                        right = mid - 1;
                    }
                }
                arr.set(ans, num);
            }
        }

        return arr.size();
    }
}