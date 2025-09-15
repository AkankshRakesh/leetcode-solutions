class Solution {
    public int canBeTypedWords(String text, String bl) {
        boolean[] map = new boolean[26];
        for(char ch : bl.toCharArray()){
            map[ch - 'a'] = true;
        }
        
        boolean res = true;
        int count = 0;
        for(int ch : text.toCharArray()){
            if(ch == ' '){
                if(res) count++;
                res = true;
            }
            else{
                if(map[ch - 'a'] == true) res = false;
            }
        }
        if(res) count++;
        return count;
    }
}