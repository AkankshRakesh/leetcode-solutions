class KthLargest {
public:
    void merge(vector<int>& arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        vector<int> left(n1), right(n2);

        for(int i = 0; i < n1; i++){
            left[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = arr[ mid + 1 + j ];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
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
    void mergeSort(vector<int>& arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
    vector<int> stream;
    int k;
    KthLargest(int k, vector<int>& nums) {
        this -> k = k;
        for(int i : nums){
            stream.push_back(i);
        }
        mergeSort(stream, 0, stream.size() - 1);
    }
    
    int add(int val) {
        int index = getIndex(val);
        // Add val to correct position
        stream.insert(stream.begin() + index, val);
        return stream[stream.size() - k];
    }

private:
    int getIndex(int val) {
        int left = 0;
        int right = stream.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = stream[mid];
            if (midValue == val) return mid;
            if (midValue > val) {
                // Go to left half
                right = mid - 1;
            } else {
                // Go to right half
                left = mid + 1;
            }
        }
        return left;
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */