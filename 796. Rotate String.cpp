#include <iostream>
using namespace std;
class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.length() != goal.length()) return false;

        return (s + s).find(goal) < s.length();
    }
};