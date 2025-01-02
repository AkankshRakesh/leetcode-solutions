class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> validStrings(words.size());
        for(int i = 0; i < words.size(); i++){
            int last = words[i].length() - 1;
            if((words[i][0] == 'a' || words[i][0] == 'e' || words[i][0] == 'i' |words[i][0] == 'o' || words[i][0] == 'u') && (words[i][last] == 'a' || words[i][last] == 'e' || words[i][last] == 'i' |words[i][last] == 'o' || words[i][last] == 'u')){
                if(i == 0) validStrings[i] = 1;
                else validStrings[i] = validStrings[i - 1] + 1;
                continue;
            }
            if(i == 0) validStrings[i] = 0;
            else validStrings[i] = validStrings[i - 1];
        }
        vector<int> ans(queries.size());
        for(int i = 0; i < queries.size(); i++){
            if(queries[i][0] == 0){
                ans[i] = validStrings[queries[i][1]];
            }
            else{
                ans[i] = validStrings[queries[i][1]] - validStrings[queries[i][0] - 1];
            }
        }
        return ans;
    }
};