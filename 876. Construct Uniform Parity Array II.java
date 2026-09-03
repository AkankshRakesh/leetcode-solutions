class Solution {
    public boolean canOdd(int[] nums, int odd){
        for(int num : nums){
            if(num % 2 == 0 && num < odd) return false;
        }

        return true;
    }
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE, smallestEven = Integer.MAX_VALUE;
        for(int num : nums1){
            if(num % 2 != 0 && num < smallestOdd) smallestOdd = num;
            else if(num % 2 == 0 && num < smallestEven) smallestEven = num;
        }

        if(smallestOdd == Integer.MAX_VALUE || smallestEven == Integer.MAX_VALUE) return true;

        return canOdd(nums1, smallestOdd);
    }
}