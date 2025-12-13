class Solution {
public:
    vector<string> validateCoupons(vector<string>& code,
                                   vector<string>& businessLine,
                                   vector<bool>& isActive) {
        vector<string> ans;
        int n = code.size();
        string match = "electronics";

        while (match != ".") {
            vector<string> temp;

            for (int i = 0; i < n; i++) {
                if (businessLine[i] == match && isActive[i]) {
                    string coupon = code[i];
                    bool isValid = true;

                    for (int j = 0; j < coupon.length(); j++) {
                        char ch = coupon[j];
                        if (!((ch >= 'a' && ch <= 'z') ||
                              (ch >= 'A' && ch <= 'Z') ||
                              (ch >= '0' && ch <= '9') ||
                              ch == '_')) {
                            isValid = false;
                            break;
                        }
                    }

                    if (!isValid || coupon.length() == 0) continue;
                    temp.push_back(coupon);
                }
            }

            sort(temp.begin(), temp.end());
            for (string& str : temp) ans.push_back(str);

            if (match == "electronics") match = "grocery";
            else if (match == "grocery") match = "pharmacy";
            else if (match == "pharmacy") match = "restaurant";
            else match = ".";
        }

        return ans;
    }
};
