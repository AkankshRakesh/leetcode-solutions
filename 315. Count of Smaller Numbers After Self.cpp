class Solution {
    vector<int> ans;
    vector<int> index;

public:
    void merge(vector<int>& nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        vector<int> leftArr(n1);
        vector<int> rightArr(n2);

        vector<int> leftIndex(n1);
        vector<int> rightIndex(n2);

        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
            leftIndex[i] = index[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = nums[mid + 1 + j];
            rightIndex[j] = index[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                ans[leftIndex[i]] += j;

                nums[k] = leftArr[i];
                index[k++] = leftIndex[i++];
            }
            else {
                nums[k] = rightArr[j];
                index[k++] = rightIndex[j++];
            }
        }

        while (i < n1) {
            ans[leftIndex[i]] += j;

            nums[k] = leftArr[i];
            index[k++] = leftIndex[i++];
        }

        while (j < n2) {
            nums[k] = rightArr[j];
            index[k++] = rightIndex[j++];
        }
    }

    void mergeSort(vector<int>& nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    vector<int> countSmaller(vector<int>& nums) {
        index.resize(nums.size());

        for (int i = 0; i < nums.size(); i++) {
            ans.push_back(0);
            index[i] = i;
        }

        mergeSort(nums, 0, nums.size() - 1);

        return ans;
    }
};