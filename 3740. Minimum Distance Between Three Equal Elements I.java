class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int ind = 0;
        for(int num : nums){
            if(hm.containsKey(num)) hm.get(num).add(ind);
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(ind);
                hm.put(num, arr);
            }
            ind++;
        }

        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Integer, ArrayList<Integer>> ele : hm.entrySet()){
            int num = ele.getKey();
            ArrayList<Integer> inds = ele.getValue();
            if(inds.size() < 3) continue;
            for(int i = 2; i < inds.size(); i++){
                int curr = inds.get(i) - inds.get(i - 2);
                curr += inds.get(i) - inds.get(i - 1);
                curr += inds.get(i - 1) - inds.get(i - 2);
                ans = Math.min(ans, curr);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}