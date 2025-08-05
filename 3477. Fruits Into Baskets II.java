class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int unset = 1;
            for (int j = 0; j < n; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    unset = 0;
                    break;
                }
            }
            ans += unset;
        }

        return ans;
    }
}