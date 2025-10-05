class Solution {
    class Triplet{
        char ch;
        int freq;
        int time;
        public Triplet(char ch, int freq, int time){
            this.freq = freq;
            this.ch = ch;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.time != b.time ? Integer.compare(a.time, b.time) : Integer.compare(b.freq, a.freq));
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : tasks) hm.put(ch, hm.getOrDefault(ch, 0) + 1);

        for(Map.Entry<Character, Integer> ele : hm.entrySet()){
            pq.offer(new Triplet(ele.getKey(), ele.getValue(), 0));
        }

        int currTime = 0;
        while(!pq.isEmpty()){
            Triplet tp = pq.poll();
            if(tp.time > currTime) currTime = tp.time;
            if(tp.freq != 1) pq.offer(new Triplet(tp.ch, tp.freq - 1, tp.time + n + 1));

            currTime++;
        }
        return currTime;
    }
}