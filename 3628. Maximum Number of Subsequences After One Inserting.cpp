class Solution {
public:
    long long countLCT(const string& s) {
        long long l = 0, lc = 0, lct = 0;

        for (char ch : s) {
            if (ch == 'L') l++;
            else if (ch == 'C') lc += l;
            else if (ch == 'T') lct += lc;
        }

        return lct;
    }

    long long numOfSubsequences(string s) {
        int n = s.length();
        long long c = countLCT(s);
        long long gain = 0;

        vector<long long> sufT(n + 1, 0);
        for (int i = n - 1; i >= 0; i--) {
            sufT[i] = (s[i] == 'T' ? 1 : 0) + sufT[i + 1];
        }

        vector<long long> preL(n + 1, 0);
        for (int i = 0; i < n; i++) {
            preL[i + 1] = (s[i] == 'L' ? 1 : 0) + preL[i];
        }

        for (int i = 0; i <= n; i++) {
            long long temp = preL[i] * sufT[i];
            gain = max(gain, temp);
        }

        int l = 0;
        int lc = 0;
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == 'L') {
                l++;
            } else if (ch == 'C') {
                lc += l;
            }
            gain = max(gain, (long long)lc);
        }

        vector<long long> sufC(n + 1, 0);
        for (int i = n - 1; i >= 0; i--) {
            sufC[i] = sufC[i + 1] + (s[i] == 'C' ? 1 : 0);
        }

        long long t = 0;
        long long tempGain = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'T') t++;
            else if (s[i] == 'C') tempGain += t;
        }

        gain = max(gain, tempGain);

        return c + gain;
    }
};
