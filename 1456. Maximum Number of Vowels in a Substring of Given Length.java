class Solution {
    public boolean isVowel(char ch){
        switch(ch){
            case 'a': 
                return true;
            case 'e': 
                return true;
            case 'o': 
                return true;
            case 'i': 
                return true;
            case 'u': 
                return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))) count++;
        }

        int ans = count;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i - k))) count--;
            if(isVowel(s.charAt(i))) count++;

            ans = Math.max(ans, count);
        }

        return ans;
    }
}