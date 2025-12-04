class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            if(i == 0){
                ans.add(temp);
                continue;
            }
            if(i == 1){
                temp.add(1);
                ans.add(temp);
                continue;
            }
            
            for(int j = 1; j < i; j++) temp.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}