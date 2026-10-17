class Solution {
    public int minSwaps(int[] nums) {
        int[][] arr = new int[nums.length][2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int sum = 0;
            while(temp != 0){
                sum += temp % 10;
                temp /= 10;
            }

            hm.put(nums[i], i);

            arr[i][0] = sum;
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(arr[i][1] != nums[i]){
                int swapIndex = hm.get(arr[i][1]);
                hm.put(nums[i], swapIndex);
                hm.put(arr[i][1], i);
                ans++;
                int temp = nums[i];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
            }
        }

        return ans;
    }
}