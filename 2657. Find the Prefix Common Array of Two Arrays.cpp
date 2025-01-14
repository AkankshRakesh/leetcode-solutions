class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        vector<int> numA(51, 0), numB(51, 0), ans;
        int matchedYet = 0;
        for(int i = 0; i < A.size() && i < B.size(); i++){
            numA[A[i]]++;
            if(numA[A[i]] == numB[A[i]]) matchedYet++;
            numB[B[i]]++;
            if(numA[B[i]] == numB[B[i]]) matchedYet++;
            ans.push_back(matchedYet);
        }
        return ans;
    }
};