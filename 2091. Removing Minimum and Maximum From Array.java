class Solution {
    public int minimumDeletions(int[] nums) {
        int largest = 0;
        int smallest = 0;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[largest] < nums[i]) largest = i;
            if(nums[smallest] > nums[i]) smallest = i;
        }

        // System.out.println(largest +  " " + smallest);
        if(largest == smallest) return Math.min(largest + 1, n - largest);
        else if(largest < smallest) return Math.min(smallest + 1, Math.min(n - largest, largest + 1 + n - smallest));
        return Math.min(largest + 1, Math.min(n - smallest, smallest + 1 + n - largest));
    }
}