class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        String ans = "";

        int len = n - numFriends + 1;
        
        for(int i = 0; i < n; i++){
            String temp;
            if(i + len <= word.length()) temp = word.substring(i, i + len);
            else temp = word.substring(i);

            if(temp.compareTo(ans) > 0) ans = temp;
        }
        return ans;
    }
}