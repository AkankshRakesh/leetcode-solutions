class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int finalRotations = Integer.MAX_VALUE;
        for(int domino = 1; domino <= 6;  domino++){
            boolean found = true;
            int rotations = 0;
            for(int i = 0; i < tops.length; i++){
                if(tops[i] != domino && bottoms[i] != domino){
                    found = false;
                    break;
                }
                if(bottoms[i] == domino && tops[i] != domino) rotations++;
            }
            if(found) finalRotations = finalRotations < rotations ? finalRotations : rotations;
        }
        for(int domino = 1; domino <= 6;  domino++){
            boolean found = true;
            int rotations = 0;
            for(int i = 0; i < bottoms.length; i++){
                if(tops[i] != domino && bottoms[i] != domino){
                    found = false;
                    break;
                }
                if(tops[i] == domino && bottoms[i] != domino) rotations++;
            }
            if(found) finalRotations = finalRotations < rotations ? finalRotations : rotations;
        }
        if(finalRotations == Integer.MAX_VALUE) return -1;
        return finalRotations;
    }
}