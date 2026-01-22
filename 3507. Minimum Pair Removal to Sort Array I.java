class Solution {
    public boolean check(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) < arr.get(i - 1))
                return false;

        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums)
            arr.add(num);

        while (!check(arr)) {
            int sum = Integer.MAX_VALUE;
            for (int i = 1; i < arr.size(); i++)
                sum = Math.min(sum, arr.get(i) + arr.get(i - 1));

            ArrayList<Integer> changedArr = new ArrayList<>();
            boolean merged = false;

            for (int i = 0; i < arr.size();) {
                if (!merged && i + 1 < arr.size()
                        && arr.get(i) + arr.get(i + 1) == sum) {
                    changedArr.add(arr.get(i) + arr.get(i + 1));
                    merged = true;
                    i += 2;
                } else {
                    changedArr.add(arr.get(i));
                    i++;
                }
            }

            arr = changedArr;
        }

        return nums.length - arr.size();
    }
}