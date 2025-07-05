class Solution {
    public boolean isVow(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        return false;
    }
    public int maxVowels(String s, int k) {
        int left = 0, right = k - 1;
        int n = s.length();
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i <= right && i < n; i++) if(isVow(s.charAt(i))) count++;
        if(maxCount < count) maxCount = count;
        while(right < n){
            if(maxCount < count) maxCount = count;
            if(isVow(s.charAt(left))) count--;
            left++;
            right++;
            if(right < n && isVow(s.charAt(right))) count++;
        }

        if(maxCount < count) maxCount = count;
        return maxCount;
    }
}