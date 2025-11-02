class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int n1 = word1.length(), n2 = word2.length(), i = 0, j = 0;
        bool first = true;
        string result = "";
        while(i < n1 && j < n2){
            if(first){
                result += word1[i++];
                first = false;
            }
            else{
                result += word2[j++];
                first = true;
            }
        }
        while(i < n1){
            result += word1[i++];
        }
        while(j < n2){
            result += word2[j++];
        }
        return result;
    }
};