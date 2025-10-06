class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        HashMap<Integer, Stack<Integer>> buckets = new HashMap<>();
        for(Map.Entry<Integer, Integer> ele : hm.entrySet()){
            if(!buckets.containsKey(ele.getValue())){
                Stack<Integer> st = new Stack<>();
                st.push(ele.getKey());
                buckets.put(ele.getValue(), st);
            }
            else buckets.get(ele.getValue()).push(ele.getKey());
        }

        int[] ans = new int[k];
        for(int i = n; i >= 0 && k > 0; i--){
            if(buckets.containsKey(i)){
                Stack<Integer> st = buckets.get(i);
                while(!st.isEmpty() && k > 0) ans[--k] = st.pop();
            }
        }

        return ans;
    }
}