class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> arr;
        int n = s.length();

        vector<vector<bool>> front(n, vector<bool>(26, false));
        vector<vector<bool>> back(n, vector<bool>(26, false));

        front[0][s[0] - 'a'] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                front[i][j] = front[i - 1][j];
            }
            front[i][s[i] - 'a'] = true;
        }

        back[n - 1][s[n - 1] - 'a'] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                back[i][j] = back[i + 1][j];
            }
            back[i][s[i] - 'a'] = true;
        }

        int lastInd = 0;
        for (int i = 0; i < n - 1; i++) {
            bool res = true;
            for (int j = 0; j < 26; j++) {
                if (front[i][j] && back[i + 1][j]) {
                    // cout << j << endl; // debug print
                    res = false;
                    break;
                }
            }
            if (res) {
                arr.push_back(i - lastInd + 1);
                lastInd = i + 1;
            }
        }

        arr.push_back(n - lastInd);
        return arr;
    }
};
