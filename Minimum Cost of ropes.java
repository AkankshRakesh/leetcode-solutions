class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) pq.offer(num);
        
        int cost = 0;
        while(pq.size() >= 2){
            int ele1 = pq.poll();
            int ele2 = pq.poll();
            cost += (ele1 + ele2);
            // System.out.println(ele1 + ele2);
            
            pq.offer(ele1 + ele2);
        }
        
        return cost;
    }
}