class Solution {
public:
    static bool myCmp(string s1, string s2){
        if(s1.size() == s2.size()){
            return s1 < s2;
        }
        else{
            return s1.size() < s2.size();
        }
    }
    vector<string> stringMatching(vector<string>& words) {
        int n = words.size();
        vector<string> ans;
        sort(words.begin(), words.end(), myCmp);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(words[j].find(words[i]) != string::npos){
                    ans.push_back(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
};