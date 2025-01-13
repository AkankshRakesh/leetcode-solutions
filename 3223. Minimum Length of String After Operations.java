class Solution {
    public int minimumLength(String s) {
        int numArr[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            numArr[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(numArr[i] >= 3){
                if(numArr[i] % 2 == 0) numArr[i] = 2;
                else numArr[i] = 1;
            }
            ans += numArr[i];
        }
        return ans;
    }
}