class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res = "";
        Queue<String> q=new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String top = q.poll();
            for(char ch = 'a'; ch <= 'z'; ch++){
                String word = top + ch;
                if(isK(word, s, k)){
                    res = word;
                    q.add(word);
                }
            }
        }

        return res;
    }

    public boolean isK(String word, String s, int k){
        int c = 0, i = 0, n = word.length();
        for(char ch: s.toCharArray()){
            if(ch == word.charAt(i)){
                if(++i == n){
                    i = 0;
                    if(++c == k) return true;
                }
            }
        }
        return false;
    }
}