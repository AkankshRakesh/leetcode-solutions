class Solution {
public:
        inline static vector<string> toStringVec(string s) {
        vector<string> ans;
        const char sep[2] = " ";
        char str[101];
        strcpy(str, s.c_str());//to C-string
        char* token;

        token = strtok(str, sep);

        while (token != NULL) {
            ans.push_back(string(token));// to C++ string
            token = strtok(NULL, sep);
        }
        return ans;
    }
    static bool areSentencesSimilar(string sentence1, string sentence2) {
        auto s1=toStringVec(sentence1), s2=toStringVec(sentence2);
        int n1=s1.size(), n2=s2.size();
        if (n1>n2) swap(n1, n2), swap(s1, s2);
        int l=0, r2=n2-1, r1=n1-1;
        for( ;l<n1 && s1[l]==s2[l]; l++);
        for( ;r1>=0 && s1[r1]==s2[r2]; r2--, r1--);
        return r1<l;
    }
};