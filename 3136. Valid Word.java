class Solution {
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
    public boolean isNum(char c){
        if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') return true;
        return false;
    }
    public boolean isValid(String word) {
        boolean vowel = false, consonant = false;
        if(word.length() < 3) return false;
        word = word.toLowerCase();

        for(int i = 0; i < word.length(); i++){
            if(isVowel(word.charAt(i))) vowel = true;
            else if (Character.isLetter(word.charAt(i))) consonant = true;
            else if (!isNum(word.charAt(i))) return false;
        }

        return vowel && consonant;
    }
}