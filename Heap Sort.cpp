class Solution {
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void heapify(int arr[], int n, int index){
        int largest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        
        if(l < n && arr[l] > arr[largest]) largest = l;
        if(r < n && arr[r] > arr[largest]) largest = r;
        
        if(largest != index){
            swap(arr, largest, index);
            heapify(arr, n, largest);
        }
    }
    
    public void heapSort(int arr[]) {
        int n = arr.length;
        for(int i = (n - 1) / 2; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n - 1; i >= 0; i--){
            swap(arr, i, 0);  // largest element placed at last
            heapify(arr, i, 0);
        }
    }
}