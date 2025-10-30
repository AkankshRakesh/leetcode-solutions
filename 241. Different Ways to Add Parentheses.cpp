class Solution {
public:
    void merge(vector<int>& res, const vector<int>& x, const vector<int>& y, char opt) {
        if (opt == '+') {
            for (int ele1 : x) {
                for (int ele2 : y) {
                    res.push_back(ele1 + ele2);
                }
            }
        } 
        else if (opt == '-') {
            for (int ele1 : x) {
                for (int ele2 : y) {
                    res.push_back(ele1 - ele2);
                }
            }
        } 
        else {
            for (int ele1 : x) {
                for (int ele2 : y) {
                    res.push_back(ele1 * ele2);
                }
            }
        }
    }

    vector<int> divide(string exp) {
        vector<int> res;
        bool optFound = false;

        for (int i = 0; i < exp.size(); i++) {
            if (exp[i] == '+' || exp[i] == '-' || exp[i] == '*') {
                optFound = true;
                string part1 = exp.substr(0, i);
                string part2 = exp.substr(i + 1);
                vector<int> x = divide(part1);
                vector<int> y = divide(part2);
                merge(res, x, y, exp[i]);
            }
        }

        if (!optFound) {
            res.push_back(stoi(exp));
        }

        return res;
    }

    vector<int> diffWaysToCompute(string expression) {
        return divide(expression);
    }
};