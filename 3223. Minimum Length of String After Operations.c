int minimumLength(char* s) {
    int numArr[26] = {0}; 
    int length = strlen(s);
    
    for (int i = 0; i < length; i++) {
        numArr[s[i] - 'a']++;
    }
    
    int ans = 0;
    for (int i = 0; i < 26; i++) {
        if (numArr[i] >= 3) {
            if (numArr[i] % 2 == 0) 
                numArr[i] = 2;
            else 
                numArr[i] = 1;
        }
        ans += numArr[i];
    }
    
    return ans;
}

