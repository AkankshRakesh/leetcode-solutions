class Solution {
    public long minCost(String s, int[] cost) {
        HashMap<Character, Long> hm = new HashMap<>();
        long totalCost = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0l) + cost[i]);
            totalCost += cost[i];
        }

        long maxCost = 0;
        for(Map.Entry<Character, Long> ele : hm.entrySet()){
            maxCost = Math.max(maxCost, ele.getValue());
        }

        return totalCost - maxCost;
    }
}