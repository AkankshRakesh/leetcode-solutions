class Solution {
public:
    bool backtrack(string& bottom,
                   int index,
                   unordered_map<string, vector<char>>& allowedHm,
                   string& nextRow,
                   unordered_map<string, bool>& memo) {

        if (index == bottom.length() - 1) {
            if (nextRow.length() == 1) return true;

            string next = nextRow;
            if (memo.count(next)) return memo[next];

            string empty = "";
            bool res = backtrack(next, 0, allowedHm, empty, memo);
            memo[next] = res;
            return res;
        }

        char first = bottom[index];
        char second = bottom[index + 1];
        string base;
        base.push_back(first);
        base.push_back(second);

        if (!allowedHm.count(base)) return false;

        for (char ch : allowedHm[base]) {
            nextRow.push_back(ch);
            if (backtrack(bottom, index + 1, allowedHm, nextRow, memo))
                return true;
            nextRow.pop_back();
        }

        return false;
    }

    bool pyramidTransition(string bottom, vector<string>& allowed) {
        unordered_map<string, vector<char>> allowedHm;
        unordered_map<string, bool> memo;

        for (string& str : allowed) {
            string base;
            base.push_back(str[0]);
            base.push_back(str[1]);

            if (allowedHm.count(base))
                allowedHm[base].push_back(str[2]);
            else
                allowedHm[base] = vector<char>{str[2]};
        }

        string nextRow = "";
        return backtrack(bottom, 0, allowedHm, nextRow, memo);
    }
};
