class Solution {
    void mergeSort(int arr[], int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];
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
    void merge(int arr[], int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;

            merge(arr, left, mid);
            merge(arr, mid + 1, right);
            mergeSort(arr, left, mid, right);
        }
    }
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        merge(nums, 0, n - 1);
        for(int i = 0; i < n; i+=2){
            if(nums[i] != nums[i + 1]) return false;
        }
        return true;
    }
}