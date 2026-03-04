class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0] - a[0], b[1] - a[1]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int index = 0;
        int[][] custQuery = new int[queries.length][2];
        for(int query : queries){
            custQuery[index][0] = query;
            custQuery[index][1] = index;
            index++;
        }
        Arrays.sort(custQuery, (a, b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[queries.length];
        index = 0;

        for(int[] query : custQuery){
            while(index < intervals.length && intervals[index][0] <= query[0]){
                pq.offer(intervals[index]);
                index++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < query[0]) pq.poll();
            if(!pq.isEmpty()) ans[query[1]] = pq.peek()[1] - pq.peek()[0] + 1;
            else ans[query[1]] = -1;
        }

        return ans;
    }
}