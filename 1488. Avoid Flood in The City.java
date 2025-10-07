class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> ts = new TreeSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[rains.length];
        for(int i = 0; i < rains.length; i++) ans[i] = 1;
        
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0) ts.add(i);
            else{
                ans[i] = -1;
                if(hm.containsKey(rains[i])){
                    int pastInd = hm.get(rains[i]);
                    Integer dryInd = ts.higher(pastInd);
                    if(dryInd == null) return new int[0];
                    
                    ans[dryInd] = rains[i];
                    ts.remove(dryInd);
                }
                hm.put(rains[i], i);
            }
        }

        return ans;
    }
}