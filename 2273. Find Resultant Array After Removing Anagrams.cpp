class Solution {
public:
    vector<int> getArr(const string &word) {
        vector<int> ans(26, 0);
        for (int i = 0; i < (int)word.size(); i++) {
            ans[word[i] - 'a']++;
        }
        return ans;
    }

    bool isAnagram(const vector<int> &w1, const vector<int> &w2) {
        for (int i = 0; i < 26; i++) {
            if (w1[i] != w2[i]) return false;
        }
        return true;
    }

    vector<string> removeAnagrams(vector<string> &words) {
        stack<vector<int>> st;
        stack<string> ansSt;

        st.push(getArr(words[0]));
        ansSt.push(words[0]);

        for (int i = 1; i < (int)words.size(); i++) {
            string word = words[i];
            vector<int> currWord = getArr(word);
            vector<int> pastWord = st.top();
            if (!isAnagram(currWord, pastWord)) {
                st.push(currWord);
                ansSt.push(word);
            }
        }

        vector<string> ans;
        while (!ansSt.empty()) {
            ans.push_back(ansSt.top());
            ansSt.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};