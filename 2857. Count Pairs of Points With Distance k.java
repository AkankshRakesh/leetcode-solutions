class Solution {
    public int countPairs(List<List<Integer>> coords, int k) {
        int ans = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = coords.size() - 1; i >= 0; i--){
            int x1 = coords.get(i).get(0);
            int y1 = coords.get(i).get(1);

            for(int u = 0; u <= k; u++){
                int x2 = u ^ x1;
                int y2 = (k - u) ^ y1;

                String key = x2 + "#" + y2;
                if(hm.containsKey(key)) ans += hm.get(key);
            }

            String key = x1 + "#" + y1;
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        return ans;
    }
}