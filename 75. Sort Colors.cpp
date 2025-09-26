class Solution {
public:
    void merge(vector<int>& arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        int L[n1], R[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = l;
        
        while(i < n1 && j < n2){
            if(L[i] <=  R[j]){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
            }
        }
        while(i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }
    }
    void mergeSort(vector<int>& nums, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            
            merge(nums, left, mid, right);
        }
    }
    void sortColors(vector<int>& nums) {
        mergeSort(nums, 0, nums.size()-1);
    }
};