int maxFrequencyElements(int* nums, int numsSize) {
    int arr[1000] = {0};
    for(int i = 0; i < numsSize; i++){
        arr[nums[i]]++;
    }
    int max = 0;
    for(int i = 0; i < 1000; i++){
        if(arr[i]>max){
            max = arr[i];
        }
    }
    int ans = 0;
    for(int i = 0; i<1000;i++){
        if (max==arr[i]){
            ans++;
        }
    }
    return ans*max;
}