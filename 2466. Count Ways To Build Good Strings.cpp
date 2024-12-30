#define MOD 1000000007

int countGoodStrings(int low, int high, int zero, int one) {
    int *possibleStrings = (int *)calloc(high + 1, sizeof(int));
    possibleStrings[0] = 1;
    int ans = 0;

    for (int i = 1; i <= high; i++) {
        if (i >= zero) {
            possibleStrings[i] = (possibleStrings[i] + possibleStrings[i - zero]) % MOD;
        }
        if (i >= one) {
            possibleStrings[i] = (possibleStrings[i] + possibleStrings[i - one]) % MOD;
        }
        if (i >= low) {
            ans = (ans + possibleStrings[i]) % MOD;
        }
    }

    free(possibleStrings);
    return ans;
}