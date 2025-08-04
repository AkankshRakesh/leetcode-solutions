class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        int n = fruits.length;
        if(n == 1) return 1;
        hm.put(fruits[0], 1);
        
        int maxSize = 1;
        for(int right = 1; right < n; right++){
            hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);

            while(hm.size() > 2){
                int count = hm.get(fruits[left]);
                if(count == 1) hm.remove(fruits[left]);
                else hm.put(fruits[left], count - 1);
                left++;
            }

            maxSize = maxSize > right - left + 1 ? maxSize : right - left + 1;
        }

        return maxSize;
    }
}