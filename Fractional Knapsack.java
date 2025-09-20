class Solution {
    class Pair{
        int index;
        double val;
        public Pair(int index, double val){
            this.index = index;
            this.val = val;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));
        for(int i = 0; i < val.length; i++) pq.offer(new Pair(i, (double)val[i] / (double)wt[i]));
        
        int currCap = 0;
        double profit = 0.0;
        while(!pq.isEmpty() && currCap < capacity){
            int index = pq.poll().index;
            if(currCap + wt[index] > capacity){
                double remaining = capacity - currCap;
                profit += remaining * ((double) val[index] / wt[index]);
                break;
            }
            profit += val[index];
            currCap += wt[index];
        }
        
        return profit;
    }
}