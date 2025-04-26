long long countSubarrays(int* nums, int numsSize, int minK, int maxK) {
    long long ans = 0;
    int maxi = -1, mini = -1;
    for(int r = 0, l = 0 ; r < numsSize; r++){
        int x = nums[r];
        if (x < minK || x > maxK){
            l = r + 1;
            continue;
        }
        if(x == maxK){
            maxi = r;
        }
        if(x == minK){
            mini = r;
        }
        int y = maxi < mini ? maxi : mini;
        y += 1 - l;
        int z = y > 0 ? y : 0;
        ans += z;
    }
    return ans;
}