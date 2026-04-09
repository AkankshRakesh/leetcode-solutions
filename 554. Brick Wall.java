class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int rowSum = 0;
        for(List<Integer> layer : wall){
            int sum = 0;
            for(int brick : layer){
                sum += brick;
                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }
            rowSum = sum;
        }
        int ans = wall.size();
        for(Map.Entry<Integer, Integer> ele : sums.entrySet()){
            if(ele.getKey() == rowSum) continue;
            ans = Math.min(ans, wall.size() - ele.getValue());
        }
        
        return ans;
    }
}