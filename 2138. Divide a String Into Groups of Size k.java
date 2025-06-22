class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int partitions = (n + k - 1) / k;
        String[] ans = new String[partitions];
        int ind = 0;

        for(int i = 0; i < n; i+=k){
            String ele = "";
            for(int j = i; j < i + k && j < n; j++){
                ele += s.charAt(j);
            }

            while(ele.length() != k){
                ele += fill;
            }
            ans[ind++] = ele;
        }
        return ans;
    }
}