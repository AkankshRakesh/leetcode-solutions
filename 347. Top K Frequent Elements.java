class Solution {
    class Pair{
        int ele;
        int count;
        public Pair(int ele, int count){
            this.ele = ele;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);
        for(Map.Entry<Integer, Integer> ele : hm.entrySet()) pq.offer(new Pair(ele.getKey(), ele.getValue()));

        int[] ans = new int[k];
        while(k != 0){
            ans[--k] = pq.poll().ele;
        }

        return ans;
    }
}