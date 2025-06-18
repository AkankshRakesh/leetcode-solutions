class Solution {
    public void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
    }
    public void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        for(int num: nums) System.out.print(num);

        int[][] ans = new int[n / 3][3];
        boolean ansFound = true;

        for(int i = 0; i < n; i += 3){
            if(nums[i + 2] - nums[i] <= k && nums[i + 2] - nums[i + 1] <= k){
                ans[i / 3][0] = nums[i];
                ans[i / 3][1] = nums[i + 1];
                ans[i / 3][2] = nums[i + 2];
            }
            else{
                ansFound = false;
                break;
            }
        }

        if(!ansFound) return new int[0][0];
        return ans;
    }
}