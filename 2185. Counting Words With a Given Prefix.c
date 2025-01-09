int prefixCount(char** words, int wordsSize, const char* pref) {
    int n = strlen(pref), ans = 0;

    for (int i = 0; i < wordsSize; i++) {
        if (strlen(words[i]) >= n && words[i][0] == pref[0] && words[i][n - 1] == pref[n - 1]) {
            char s[101];
            strncpy(s, words[i], n);
            s[n] = '\0'; 

            if (strcmp(s, pref) == 0) {
                ans++;
            }
        }
    }

    return ans;
}
