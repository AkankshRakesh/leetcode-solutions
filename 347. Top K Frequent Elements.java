class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[k];

        for(int num: nums){
            if(hm.containsKey(num)){
                int count = hm.get(num);
                hm.put(num, count + 1);
            }
            else hm.put(num, 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(hm.entrySet());

        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int ind = 0;
        for(Map.Entry<Integer, Integer> ele : sortedEntries){
            if(ind >= k) break;
            arr[ind++] = ele.getKey();
        }

        return arr;
    }
}