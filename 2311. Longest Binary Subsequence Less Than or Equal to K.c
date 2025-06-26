
int longestSubsequence(char* s, int k) {
    int count = 0;
    int n = strlen(s);
    int currInt = 0;
    int currInd = 0;
    int flag = 0;

    for (int i = n - 1; i >= 0; --i) {
        if (currInt >= k) flag = 1;

        if (s[i] == '1' && !flag) {
            if (currInd < 31 && (1 << currInd) <= k - currInt) {
                currInt += (1 << currInd);
                if (currInt >= k) {
                    flag = 1;
                    if (currInt != k) continue;
                }
                count++;
            } else {
                flag = 1; 
            }
        } else if (s[i] == '0') {
            count++;
        }

        currInd++;
    }

    return count;
}