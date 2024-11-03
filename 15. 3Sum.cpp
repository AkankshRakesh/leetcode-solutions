class Solution {
public:
    void merge(vector<int>& nums, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        vector<int> left(n1), right(n2);
        for(int i = 0; i < n1; i++){
            left[i] = nums[l + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                nums[k++] = left[i++];
            }
            else{
                nums[k++] = right[j++];
            }
        }
        while(i < n1){
            nums[k++] = left[i++];
        }
        while(j < n2){
            nums[k++] = right[j++];
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
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int left = 0, right = nums.size() - 1;
        mergeSort(nums, 0, right);

        for(int i = 0; i < nums.size(); i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.size() - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.push_back({nums[i], nums[j], nums[k]});
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
            
        }
        return res;
    }
};