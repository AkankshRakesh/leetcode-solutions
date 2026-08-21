class Solution {
    List<Integer> ans = new ArrayList<>();
    int[] index;

    public void merge(int[] nums, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        int[] leftIndex = new int[n1];
        int[] rightIndex = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
            leftIndex[i] = index[left + i];
        }

        for(int j = 0; j < n2; j++) {
            rightArr[j] = nums[mid + 1 + j];
            rightIndex[j] = index[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                ans.set(leftIndex[i],
                    ans.get(leftIndex[i]) + j);

                nums[k] = leftArr[i];
                index[k++] = leftIndex[i++];
            }
            else {
                nums[k] = rightArr[j];
                index[k++] = rightIndex[j++];
            }
        }

        while(i < n1){
            ans.set(leftIndex[i],
                ans.get(leftIndex[i]) + j);

            nums[k] = leftArr[i];
            index[k++] = leftIndex[i++];
        }

        while(j < n2){
            nums[k] = rightArr[j];
            index[k++] = rightIndex[j++];
        }
    }

    public void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        index = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            ans.add(0);
            index[i] = i;
        }

        mergeSort(nums, 0, nums.length - 1);

        return ans;
    }
}