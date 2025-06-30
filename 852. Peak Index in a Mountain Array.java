class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(mid > 0 && arr[mid - 1] > arr[mid]) right = mid;
            else if(mid < n - 1 && arr[mid + 1] > arr[mid]) left = mid + 1;
            else return mid;
        }
        return 0;
    }
}