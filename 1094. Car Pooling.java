class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] != b[1]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[2], b[2]));


        int curr = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < trips.length; i++){
            int[] currTrip = trips[i];

            while(!q.isEmpty() && currTrip[1] >= q.peek()[2]) curr -= q.poll()[0];
            q.offer(currTrip);
            curr += currTrip[0];

            if(curr > capacity) return false;
        }

        return true;
    }
}