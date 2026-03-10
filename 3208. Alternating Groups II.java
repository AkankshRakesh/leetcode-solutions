class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0, right = 0;
        HashSet<Integer> badIndexes = new HashSet<>();
        for(right = 1; right < k; right++){
            if(colors[right] == colors[right - 1]) badIndexes.add(right - 1);
        }
        int ans = 0;
        // if(badIndexes.isEmpty()) ans++;
        for(left = 0; left < colors.length; left++){
            if(badIndexes.isEmpty()) ans++;
            if(badIndexes.contains(left)) badIndexes.remove(left);

            int modRight = right % colors.length;
            int modPrevRight = modRight != 0 ? modRight - 1 : colors.length - 1;
            if(colors[modPrevRight] == colors[modRight]) badIndexes.add(modRight - 1);
            right++;
            // for(int indexes : badIndexes) System.out.print(indexes + " ");
            // System.out.println();

        }

        return ans;
    }
}