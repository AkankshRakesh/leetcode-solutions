class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length; j++){
                if(j - 1 != i && nums[j] == nums[j - 1]) continue; 

                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long lSum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if(lSum > Integer.MAX_VALUE){
                        left++;
                        right--;
                    }
                    else{
                        int sum = (int)lSum;
                        if(sum == target){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[left]);
                            temp.add(nums[right]);
                            ans.add(temp);

                            left++;
                            right--;
                            while(left < right && nums[left] == nums[left - 1]) left++;
                            while(left < right && nums[right] == nums[right + 1]) right--;
                        }
                        else if(sum > target) right--;
                        else left++;
                    }
                }
            }
        }

        return ans;
    }
}