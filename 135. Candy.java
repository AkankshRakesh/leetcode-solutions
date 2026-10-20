class Solution {
    public int candy(int[] ratings) {
        int[][] nums = new int[ratings.length][2];
        for(int i = 0; i < ratings.length; i++){
            nums[i][0] = ratings[i];
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        int least = nums[0][0];
        int index = 0;
        int[] candies = new int[nums.length];

        while(index < nums.length && nums[index][0] == least) candies[nums[index++][1]] = 1;

        while(index < nums.length){
            int curr = nums[index][0];

            while(index < nums.length && nums[index][0] == curr){
                int candyIndex = nums[index][1];
                int max = 1;
                if(candyIndex > 0 && ratings[candyIndex - 1] < ratings[candyIndex]) max = Math.max(max, candies[candyIndex - 1] + 1);
                if(candyIndex < nums.length - 1 && ratings[candyIndex + 1] < ratings[candyIndex]) max = Math.max(max, candies[candyIndex + 1] + 1);

                candies[candyIndex] = max;

                index++;
            }
        }

        int sum = 0;
        for(int val : candies) sum += val;

        return sum;
    }
}