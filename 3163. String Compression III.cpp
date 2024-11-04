#include <iostream>
using namespace std;
class Solution {
public:
    string compressedString(string word) {
        char temp = word[0];
        string ans = "";
        int count = 1;
        for(int i = 1; i < word.length(); i++){
            if(temp != word[i]){
                while(count > 9){
                    ans += "9";
                    count -= 9;
                    ans += temp;
                }
                ans += to_string(count);
                ans += temp;
                temp = word[i];
                count = 1;
                continue;
            }
            count++;
        }
        while(count > 9){
            ans += "9";
            count -= 9;
            ans += temp;
        }
        ans += to_string(count);
        ans += temp;
        return ans;
    }
};