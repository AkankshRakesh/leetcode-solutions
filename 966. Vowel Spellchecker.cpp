class Solution {
public:
    bool isVow(char ch) {
        switch(ch) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
        }
        return false;
    }

    string buildKey(const string &original) {
        string lower = original;
        transform(lower.begin(), lower.end(), lower.begin(), ::tolower);

        string sb;    
        string ind;  
        for (int i = 0; i < (int)lower.size(); i++) {
            if (isVow(lower[i])) ind += to_string(i);
            else sb += lower[i];
        }
        sb += '+';
        sb += ind;
        return sb;
    }

    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        unordered_map<string, int> exact;
        unordered_map<string, int> cap;
        unordered_map<string, int> vow;

        for (int i = 0; i < (int)wordlist.size(); i++) {
            exact[wordlist[i]] = i;
        }

        for (int i = 0; i < (int)wordlist.size(); i++) {
            string lower = wordlist[i];
            transform(lower.begin(), lower.end(), lower.begin(), ::tolower);
            if (cap.find(lower) == cap.end())
                cap[lower] = i;
        }

        for (int i = 0; i < (int)wordlist.size(); i++) {
            string key = buildKey(wordlist[i]);
            if (vow.find(key) == vow.end())
                vow[key] = i;
        }

        vector<string> ans(queries.size());
        for (int i = 0; i < (int)queries.size(); i++) {
            string curr = queries[i];

            if (exact.find(curr) != exact.end()) {
                ans[i] = wordlist[exact[curr]];
            } else {
                string lower = curr;
                transform(lower.begin(), lower.end(), lower.begin(), ::tolower);
                if (cap.find(lower) != cap.end()) {
                    ans[i] = wordlist[cap[lower]];
                } else {
                    string key = buildKey(curr);
                    if (vow.find(key) != vow.end()) {
                        ans[i] = wordlist[vow[key]];
                    } else {
                        ans[i] = "";
                    }
                }
            }
        }
        return ans;
    }
};
