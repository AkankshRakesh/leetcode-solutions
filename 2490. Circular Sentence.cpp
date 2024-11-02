#include <iostream>
using namespace std;
class Solution {
public:
    bool isCircularSentence(string sentence) {
        int len = sentence.size();
        for(int i = 0; i < len; i++){
            if(sentence[i] == ' '){
                if(sentence[i - 1] != sentence[i + 1]) return false;
            }
        }
        if(sentence[0] != sentence[len - 1]) return false;
        return true;
    }
};