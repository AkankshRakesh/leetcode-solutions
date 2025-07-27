class Solution {
    public List<List<Integer>> generate(int nr) {
        List<List<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        arr.add(new ArrayList<>(temp));

        if(nr == 1) return arr;
        temp.add(1);
        arr.add(new ArrayList<>(temp));

        if(nr == 2) return arr;
        for(int i = 2; i < nr; i++){
            ArrayList<Integer> level = new ArrayList<>();
            level.add(1);
            int left = 0, right = 1;
            int size = arr.get(i - 1).size();
            while(right < size){
                level.add(arr.get(i - 1).get(left) + arr.get(i - 1).get(right));
                left++;
                right++;
            }
            level.add(1);
            arr.add(level);
        }

        return arr;
    }
}