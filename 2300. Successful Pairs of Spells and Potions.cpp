class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        // HashSet<Integer> hs = new HashSet<>();
        int ans[] = new int[spells.length];
        int ind = 0;

        // for(int potion: potions) hs.add(potion);
        for(int spell: spells){
            long target = (success + spell - 1) / spell;
            int left = 0;
            int right = potions.length;

            while(left < right){
                int mid = left + (right - left) / 2;
                if(potions[mid] < target) left = mid + 1;
                else right = mid;
            }
            ans[ind++] = potions.length - left;
        }

        return ans;
    }
}