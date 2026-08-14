class Solution {
    public int maximumWidth(int[] planks) {
        HashMap<Long, Integer> freq = new HashMap<>();
        for(int plank : planks){
            freq.put((long)plank, freq.getOrDefault((long)plank, 0) + 1);
        }

        long[] values = new long[freq.size()];
        int index = 0;

        for (long value : freq.keySet()) {
            values[index++] = value;
        }

        HashMap<Long, Integer> pairs = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            long x = values[i];

            int samePairs = freq.get(x) / 2;
            if(samePairs > 0){
                pairs.put(x + x, pairs.getOrDefault(x + x, 0) + samePairs);
            }
            for (int j = i + 1; j < values.length; j++) {
                long y = values[j];
                long sum = x + y;
    
                int pair = Math.min(freq.get(x), freq.get(y));
    
                pairs.put(
                    sum,
                    pairs.getOrDefault(sum, 0) + pair
                );
            }
        }

        int ans = 1;
        for(Map.Entry<Long, Integer> ele : pairs.entrySet()){
            ans = Math.max(ans, ele.getValue() + freq.getOrDefault(ele.getKey(), 0));
        }

        for (int count : freq.values()) {
            ans = Math.max(ans, count);
        }

        return ans;
    }
}