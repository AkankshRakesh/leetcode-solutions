class Solution {
    public int minimumOperations(int[] nums) {
        int map[] = new int[101];
        for(int num : nums) map[num]++;

        int operations = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 3 == 0){
                boolean uniq = true;
                for(int j = 0; j < 101; j++){
                    if(map[j] > 1){
                        uniq = false;
                        break;
                    }
                }
                if(uniq) break;
                operations++;
            }
            map[nums[i]]--;
        }
        return operations;
    }
}