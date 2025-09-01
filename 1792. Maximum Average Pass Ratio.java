class Solution {
    class Pair{
        Integer index;
        Double ratio;
        public Pair(Integer index, Double ratio){
            this.index = index;
            this.ratio = ratio;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.ratio, a.ratio));
        int n = classes.length;
        for(int i = 0; i < n; i++){
            Double curr = (double)classes[i][0] / classes[i][1];
            Double future = (double)(classes[i][0] + 1) / (classes[i][1] + 1);
            pq.offer(new Pair(i, future - curr));
            // System.out.println(future - curr);
        }

        while(extraStudents != 0){
            Pair top = pq.poll();
            extraStudents--;
            int index = top.index;
            Double curr = (double)(classes[index][0] + 1) / (classes[index][1] + 1);
            Double future = (double)(classes[index][0] + 2) / (classes[index][1] + 2);
            pq.offer(new Pair(index, future - curr));
            
            classes[index][0]++;
            classes[index][1]++;
        }

        double ans = 0;
        for(int i = 0; i < n; i++){
            Double curr = (double)classes[i][0] / classes[i][1];
            // System.out.println(curr);
            ans += curr;
        }

        return ans / n;
    }
}