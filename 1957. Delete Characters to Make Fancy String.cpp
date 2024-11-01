#include <string>
#include <iostream>
using namespace std;
class Solution {
public:
    string makeFancyString(string s) {
        if(s.size() < 3) return s;
        string ans = "";
        int left = 0;
        for(int right = 2; right < s.size(); right++, left++){
            if(s[left] == s[right] && s[left] == s[left + 1]) continue;
            ans += s[left];
        }
        ans += s[left];
        ans += s[left + 1];
        return ans;
    }
};