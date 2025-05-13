public class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        ArrayList<Integer> freq = new ArrayList<Integer>(26);
        for(int i = 0; i < 26; i++) freq.add(0);
        for (char c : s.toCharArray()) {
            int ind = c - 'a';
            freq.set(ind, freq.get(ind) + 1);
        }

        for(int i = 0; i < t; i++){
            int zCount = freq.get(25);
            int bCount = freq.get(0);
            
            freq.remove(25);
            freq.add(0, zCount);

            freq.set(1, (bCount + zCount) % MOD);
        }

        int ans = 0;
        for(int i = 0; i < 26; i++){
            ans = (ans + freq.get(i)) % MOD;
        }
        return ans;
    }
}