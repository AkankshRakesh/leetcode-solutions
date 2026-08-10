class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int lastPartitionIndex = -1;

        int[][] prefixArr = new int[s.length()][128];
        for(int i = 0; i < s.length(); i++){
            int[] freq = prefixArr[i];
            freq[s.charAt(i)]++;

            if(i == 0) continue;
            int[] pastFreq = prefixArr[i - 1];
            for(int j = 0; j < 128; j++) freq[j] += pastFreq[j];
        }

        int[][] suffixArr = new int[s.length()][128];
        for(int i = s.length() - 1; i >= 0; i--){
            int[] freq = suffixArr[i];
            freq[s.charAt(i)]++;

            if(i == s.length() - 1) continue;
            int[] pastFreq = suffixArr[i + 1];
            for(int j = 0; j < 128; j++) freq[j] += pastFreq[j];
        }

        for(int i = 0; i < s.length() - 1; i++){
            int[] currFreq = prefixArr[i];
            int[] nextFreq = suffixArr[i + 1];

            boolean res = true;
            for(int j = 0; j < 128; j++){
                if(currFreq[j] != 0 && nextFreq[j] != 0){
                    res = false;
                    break;
                }
            }

            if(res){
                // System.out.println(i);
                ans.add(i - lastPartitionIndex);
                lastPartitionIndex = i;
            }
        }

        ans.add(s.length() - 1 - lastPartitionIndex);
        return ans;
    }
}