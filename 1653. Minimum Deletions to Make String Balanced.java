class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int[] countB = new int[n];

        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            countA[i] = count;
            if(s.charAt(i) == 'a') count++;
        }

        count = 0;
        for(int i = 0; i < n; i++){
            countB[i] = count;
            if(s.charAt(i) == 'b') count++;
        }

        int minDel = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int deletions = countA[i] + countB[i];
            if(minDel > deletions) minDel = deletions;
        }

        return minDel;
    }
}