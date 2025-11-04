class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void backtrack(int[] nums, StringBuilder currStr, List<Integer> currArr, HashSet<Integer> takenInd, HashSet<String> addedPerms,int n){
        boolean lastEle = true;
        for(int i = 0; i < n; i++){
            if(!takenInd.contains(i)){
                lastEle = false;
                currStr.append("#").append(Integer.toString(nums[i]));
                currArr.add(nums[i]);
                takenInd.add(i);
                backtrack(nums, currStr, currArr, takenInd, addedPerms, n);
                while(currStr.charAt(currStr.length() - 1) != '#') currStr.deleteCharAt(currStr.length() - 1);
                currStr.deleteCharAt(currStr.length() - 1);
                takenInd.remove(i);
                currArr.remove(currArr.size() - 1);
            }
        }

        if(lastEle){
            if(!addedPerms.contains(currStr.toString())){
                ans.add(new ArrayList<>(currArr));
                addedPerms.add(currStr.toString());
                // System.out.println(currStr.toString());
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<Integer> takenInd = new HashSet<>();
        HashSet<String> addedPerms = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            takenInd.add(i);
            List<Integer> currArr = new ArrayList<>();
            currArr.add(nums[i]);
            backtrack(nums, new StringBuilder(Integer.toString(nums[i])), currArr, takenInd, addedPerms, n);
            takenInd.remove(i);
        }

        return ans;
    }
}