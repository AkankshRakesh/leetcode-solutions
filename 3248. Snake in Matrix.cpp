class Solution {
public:
    int finalPositionOfSnake(int n, vector<string>& commands) {
        int i = 0, j = 0;
        for(int k = 0; k < commands.size(); k++){
            if(commands[k] == "DOWN"){
                j++;
            }
            else if(commands[k] == "UP"){
                j--;
            }
            else if(commands[k] == "LEFT"){
                i--;
            }
            else{
                i++;
            }
        }
        int ans = n*j + i;
        return ans;
    }
};