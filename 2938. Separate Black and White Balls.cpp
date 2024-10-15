class Solution {
public:
    long long minimumSteps(string s) {
        string before = s;
        sort(s.begin(), s.end());
        stack<long long> stZ, stO;
        for(int i = 0; i < s.size(); i++){
            if(s[i] != before[i]){
                if(s[i] == '1'){
                    stO.push(i);
                }
                else{
                    stZ.push(i);
                }
            }
        }
        long long steps = 0;
        while(!stO.empty()){
            int calc = stO.top() - stZ.top();
            stO.pop();
            stZ.pop();
            if(calc < 0) calc = -calc;
            steps += calc;
        }
        return steps;
    }
};