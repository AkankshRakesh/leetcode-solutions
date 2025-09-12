class Solution {
    public boolean isVowel(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
    public boolean doesAliceWin(String s) {
        int tot = 0;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))) tot++;
        }
        
        if(tot == 0) return false;
        return true;
    }
}