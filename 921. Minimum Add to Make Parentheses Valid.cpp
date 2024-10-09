class Solution {
public:
    int minAddToMakeValid(string s) {
        stack<int> st;
        int c = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == ')'){
                if(st.empty()){
                    c++;
                }
                else if(st.top() != '('){
                    c++;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(s[i]);
            }
        }
        return c + st.size();
    }
};