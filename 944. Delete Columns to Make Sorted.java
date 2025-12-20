class Solution {
    public int minDeletionSize(String[] strs) {
        boolean check[] = new boolean[strs[0].length()];
        Arrays.fill(check, true);

        for(int i = 1; i < strs.length; i++){
            String past = strs[i - 1];
            String curr = strs[i];
            for(int j = 0; j < past.length(); j++){
                if(past.charAt(j) > curr.charAt(j)) check[j] = false;
            }
        }

        int count = 0;
        for(boolean val : check) if(!val) count++;
        return count;
    }
}