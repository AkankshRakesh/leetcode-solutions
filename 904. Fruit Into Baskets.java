class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);

            while (hm.size() > 2) {
                hm.put(fruits[left], hm.get(fruits[left]) - 1);
                if (hm.get(fruits[left]) == 0) {
                    hm.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}