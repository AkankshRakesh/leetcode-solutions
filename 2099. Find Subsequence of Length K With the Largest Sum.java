class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num: nums) pq.add(num);

        int[] ansEle = new int[k];
        int ind = 0;
        while(k != 0){
            ansEle[ind++] = pq.poll();
            k--;
        }
        int[] ans = new int[ind];
        ind = 0;
        for(int num: nums){
            for(int i = 0; i < ansEle.length; i++){
                if(ansEle[i] == num){
                    ans[ind++] = ansEle[i];
                    ansEle[i] = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        return ans;
    }
}