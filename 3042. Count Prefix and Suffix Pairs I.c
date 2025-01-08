bool checkFromFirst(const char* main, const char* prefix) {
    int n = strlen(main), m = strlen(prefix);
    for (int i = 0, j = 0; i < n && j < m; i++, j++) {
        if (main[i] != prefix[j]) return false;
    }
    return true;
}

bool checkFromLast(const char* main, const char* suffix) {
    int n = strlen(main), m = strlen(suffix);
    for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {
        if (main[i] != suffix[j]) return false;
    }
    return true;
}

int countPrefixSuffixPairs(char** words, int wordsSize) {
    int ans = 0;
    for (int i = 0; i < wordsSize; i++) {
        for (int j = i + 1; j < wordsSize; j++) {
            if (strlen(words[i]) > strlen(words[j])) continue;
            if (checkFromLast(words[j], words[i]) && checkFromFirst(words[j], words[i])) {
                ans++;
            }
        }
    }
    return ans;
}