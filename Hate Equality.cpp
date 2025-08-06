int canYouMakeDifference(int n, const string& s) {
    char ch = s[0];
    for (int i = 1; i < n; i++) {
        if (s[i] != ch) return 1;
    }
    return 0;
}