class Solution {
    public:
        bool areAlmostEqual(string s1, string s2) {
            int n = s1.size(), count = 0, indexFirst = -1, indexSecond = -1;
            for(int i = 0; i < n; i++){
                if(s1[i] != s2[i]){
                    count++;
                    if(count == 1) indexFirst = i;
                    else if(count == 2) indexSecond = i;
                    else return false;
                }
            }
            if(count > 2 || count == 1) return false;
            if(count == 2 && (s1[indexFirst] != s2[indexSecond] || s1[indexSecond] != s2[indexFirst])) return false;
            return true;
        }
    };