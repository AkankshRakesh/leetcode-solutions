class Solution {
    int[] arr;
    int total = 0;
    public Solution(int[] w) {
        int ind = 0;
        this.arr = w;
        for(int we : w){
            total += we;
            arr[ind++] = total;
        }
    }
    
    public int pickIndex() {
        int target = (int)(Math.random() * total);
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] > target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */