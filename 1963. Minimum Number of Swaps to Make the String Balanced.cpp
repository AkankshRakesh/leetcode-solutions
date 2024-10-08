class Solution {
public:
    int minSwaps(string s) {
        int swap = 0, closing = 0;
        for(char brac : s){
            if(brac == ']'){
                if(closing == 0){
                    swap++;
                    closing++;
                }
                else{
                    closing--;
                }
            }
            else{
                closing++;
            }
        }
        return swap;
    }
};