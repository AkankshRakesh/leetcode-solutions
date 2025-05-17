class Solution {
    int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j <= high - 1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    void quickSort(int[] arr, int low, int high){
        if (low < high){
            int part = partition(arr, low, high);

            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    
    }
}