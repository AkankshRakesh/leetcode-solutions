class Solution {
    long ans = 0;
    int d;
    public void merge(int[] nums, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i < n1; i++) leftArr[i] = nums[i + left]; 
        for(int j = 0; j < n2; j++) rightArr[j] = nums[j + mid + 1];

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j] + d){
                ans += (n2 - j);
                i++;
            }
            else j++;
        }

        i = 0;
        j = 0;
        while(i < n1 && j < n2){
            if(leftArr[i] < rightArr[j]){
                nums[k++] = leftArr[i++];
            }
            else{
                nums[k++] = rightArr[j++];
            }
        }

        while(i < n1) nums[k++] = leftArr[i++];
        while(j < n2) nums[k++] = rightArr[j++];
    }
    public void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        // n1 - n2 <= m1 - m2 + d
        // n1 - m1 <= n2 - m2 + d
        int[] nums = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            nums[i] = nums1[i] - nums2[i];
        }

        d = diff;
        mergeSort(nums, 0, nums.length - 1);

        return ans;
    }
}