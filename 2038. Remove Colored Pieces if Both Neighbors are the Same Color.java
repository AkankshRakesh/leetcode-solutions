class Solution {
    public boolean winnerOfGame(String colors) {
        int aMoves = 0, bMoves = 0;
        int countA = 0, countB = 0;
        for(int i = 0; i < colors.length(); i++){
            if(colors.charAt(i) == 'A'){
                if(countB >= 3) bMoves += (countB - 2);
                countB = 0;
                countA++;
            }
            else{
                if(countA >= 3) aMoves += (countA - 2);
                countA = 0;
                countB++;
            }
        }
        if(countA >= 3) aMoves += (countA - 2);
        if(countB >= 3) bMoves += (countB - 2);
        if(aMoves > bMoves) return true;
        return false;
    }
}