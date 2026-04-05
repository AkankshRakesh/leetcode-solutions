class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;
        for(int ind = 0; ind < moves.length(); ind++){
            switch(moves.charAt(ind)){
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
}