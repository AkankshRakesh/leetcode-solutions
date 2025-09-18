class Solution {
public:
    bool check(const string& s) {
        int value = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s[i] == ')') value++;
            else value--;

            if (value < 0) return false;
        }
        return true;
    }

    void exploration(vector<string>& res, string s, int leftPara, int rightPara) {
        if (leftPara == 0 && rightPara == 0) {
            if (check(s)) {
                res.push_back(s);
            }
            return;
        } 
        else if (leftPara == 0) {
            exploration(res, s + ")", leftPara, rightPara - 1);
        }
        else if (rightPara == 0) {
            exploration(res, s + "(", leftPara - 1, rightPara);
        }
        else {
            exploration(res, s + "(", leftPara - 1, rightPara);
            exploration(res, s + ")", leftPara, rightPara - 1);
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> arr;
        exploration(arr, "(", n - 1, n);
        return arr;
    }
};
