class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[128];
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i)]++;
        }

        int[] buckets = new int[8];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 'a'; i <= 'z'; i++){
            if(freq[i] == 0) continue;
            pq.offer(new int[]{i, freq[i]});
            // System.out.println(pq.peek()[0]);
        }

        int cost = 0;
        while(!pq.isEmpty()){
            int digit = pq.poll()[0];
            int minPressesIndex = 0;
            for(int i = 0; i < 8; i++){
                if(buckets[minPressesIndex] > buckets[i]) minPressesIndex = i;
            }

            cost += (buckets[minPressesIndex] + 1) * freq[digit];
            buckets[minPressesIndex]++;
        }

        return cost;
    }
}