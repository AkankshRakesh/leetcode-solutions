class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        if (k == n) return "0";
        
        string result = "";
        for (char digit : num) {
            while (!result.empty() && result.back() > digit && k > 0) {
                result.pop_back();
                k--;
            }
            result.push_back(digit);
        }
        
        while (k > 0) {
            result.pop_back();
            k--;
        }
        
        int start = 0;
        while (start < result.size() && result[start] == '0') {
            start++;
        }
        
        string finalResult = result.substr(start);
        return finalResult.empty() ? "0" : finalResult;
    }
};