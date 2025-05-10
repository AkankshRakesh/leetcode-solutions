class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long firstZero = 0, firstSum = 0, n1 = nums1.length;
        long secondZero = 0, secondSum = 0, n2 = nums2.length;

        for(int i = 0; i < n1; i++){
            if(nums1[i] == 0) firstZero++;
            firstSum += nums1[i];
        }

        for(int j = 0; j < n2; j++){
            if(nums2[j] == 0) secondZero++;
            secondSum += nums2[j];
        }

        if(firstSum + firstZero > secondSum + secondZero){
            long minPoss = firstSum + firstZero;
            if(secondZero != 0) return minPoss;
        }
        else{
            long minPoss = secondSum + secondZero;
            if(firstZero != 0 || secondSum + secondZero == firstSum + firstZero){
                return minPoss;
            }
        }

        return -1;
    }
}