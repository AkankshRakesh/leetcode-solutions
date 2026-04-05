class Solution {
public:
    bool judgeCircle(string moves) {
        int i = 0, j = 0;
        for(int ind = 0; ind < moves.size(); ind++){
            switch(moves[ind]){
                case 'U':
                    i--;
                    break;
                case 'D':
                    i++;
                    break;
                case 'L':
                    j--;
                    break;
                case 'R':
                    j++;
                    break;
            }
        }

        if(i == 0 && j == 0) return true;
        return false;
    }
};