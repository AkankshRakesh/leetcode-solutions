class Solution {
    class Pair{
        int start;
        int finish;
        public Pair(int start, int finish){
            this.start = start;
            this.finish = finish;
        }
    }
    public int activitySelection(int[] start, int[] finish) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.finish != b.finish ? Integer.compare(a.finish, b.finish) : Integer.compare(a.start, b.start));
        for(int i = 0; i < start.length; i++){
            pq.offer(new Pair(start[i], finish[i]));
        }
        
        int count = 0;
        int time = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.start > time){
                count++;
                time = p.finish;
            }
        }
        
        return count;
    }
}
