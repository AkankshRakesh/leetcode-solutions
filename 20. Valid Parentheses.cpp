class Solution {
public:
    bool isValid(string s) {
        int len = s.size();
        if(len == 1) return false;
        vector<int> arr;
        for(int i = 0; i < len; i++){
            if(s[i] == '(' || s[i] == '{' || s[i] == '['){
                arr.push_back(s[i]);
            }
            else{
                if(arr.size() == 0) return false;
                if(s[i] == ')' && arr[arr.size() - 1] != '(') return false;
                else if(s[i] == '}' && arr[arr.size() - 1] != '{') return false;
                else if(s[i] == ']' && arr[arr.size() - 1] != '[') return false;
                arr.pop_back();
            }
        }
        return arr.size() == 0;
    }
};