class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);

        for(int i = 1; i < arr.length; i++){
            if(minDiff == arr[i] - arr[i - 1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}