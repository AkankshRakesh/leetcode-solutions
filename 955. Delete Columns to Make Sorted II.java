class Solution {
    public int minDeletionSize(String[] strs) {
        HashSet<Integer> dontCheck = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < strs[0].length(); i++){
            HashSet<Integer> copy = new HashSet<>(dontCheck);
            for(int j = 0; j < strs.length - 1; j++) {
                if(dontCheck.contains(j)) continue;
                if(strs[j].charAt(i) < strs[j + 1].charAt(i)) dontCheck.add(j);
                else if(strs[j].charAt(i) > strs[j + 1].charAt(i)){
                    ans++;
                    dontCheck = copy;
                    break;
                }
            }
        }

        return ans;
    }
}