class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        k++;
        for(int i = 0; i < k; i++) pq.offer(arr[i]);
        
        for(int i = k; i - k < arr.length; i++){
            arr[i - k] = pq.poll();
            if(i < arr.length) pq.offer(arr[i]);
        }
    }
}
