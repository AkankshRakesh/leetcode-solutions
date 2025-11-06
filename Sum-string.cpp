#include <string>
#include <algorithm>

class Solution {
public:
    std::string addStrings(const std::string& num1, const std::string& num2) {
        int i = (int)num1.size() - 1;
        int j = (int)num2.size() - 1;
        int carry = 0;
        std::string sb;
        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? num1[i] - '0' : 0;
            int d2 = (j >= 0) ? num2[j] - '0' : 0;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            sb.push_back((sum % 10) + '0');
            i--;
            j--;
        }
        std::reverse(sb.begin(), sb.end());
        return sb;
    }

    bool check(const std::string& s1, const std::string& s2, const std::string& s3) {
        std::string sum = addStrings(s1, s2);
        if (sum.size() > s3.size()) return false;
        if (sum == s3.substr(0, sum.size())) {
            if (sum.size() == s3.size()) return true;
            return check(s2, sum, s3.substr(sum.size()));
        }
        return false;
    }

    bool isSumString(const std::string& s) {
        for (size_t i = 1; i < s.size(); i++) {
            for (size_t j = 1; i + j < s.size(); j++) {
                std::string s1 = s.substr(0, i);
                std::string s2 = s.substr(i, j);
                std::string s3 = s.substr(i + j);
                if (check(s1, s2, s3)) return true;
            }
        }
        return false;
    }
};