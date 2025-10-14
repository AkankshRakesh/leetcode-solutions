/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        if(intervals.size() == 0) return 0;
        pq.offer(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            if(pq.peek() <= intervals.get(i).start) pq.poll();

            pq.offer(intervals.get(i).end);
        }

        return pq.size();
    }
}
