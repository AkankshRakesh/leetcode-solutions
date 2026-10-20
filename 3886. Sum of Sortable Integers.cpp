class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1; i <= n; i++) if(n % i == 0) factors.add(i);

        int ans = 0;
        for(int k : factors){
            int index = 0;
            int max = Integer.MIN_VALUE;
            boolean gValid = true;

            while(index < n){
                int descents = 0;
                int descentIndex = -1;

                for (int i = index; i < index + k; i++) {
                    int next = (i + 1 == index + k) ? index : i + 1;
                    if (nums[i] > nums[next]) {
                        descents++;
                        descentIndex = i;
                    }
                }

                if (descents > 1) {
                    gValid = false;
                    break;
                }

                int currMin, currMax;
                if (descents == 1) {
                    int firstIndex = (descentIndex + 1 == index + k)
                            ? index : descentIndex + 1;
                    currMin = nums[firstIndex];
                    currMax = nums[descentIndex];
                } else {
                    currMin = nums[index];
                    currMax = nums[index];
                }

                if (max > currMin) {
                    gValid = false;
                    break;
                }

                max = currMax;
                index += k;
            }

            if(gValid) ans += k;
        }

        return ans;
    }
}