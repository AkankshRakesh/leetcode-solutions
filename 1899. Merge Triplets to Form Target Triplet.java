class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        boolean ansPoss = false, t1 = false, t2 = false, t3 = false;
        int ele1 = target[0], ele2 = target[1], ele3 = target[2];

        for(int i = 0; i < n; i++){
            if(triplets[i][0] <= ele1 && triplets[i][1] <= ele2 && triplets[i][2] <= ele3){
                ansPoss = true;
                if(!t1 && triplets[i][0] == ele1) t1 = true;
                if(!t2 && triplets[i][1] == ele2) t2 = true;
                if(!t3 && triplets[i][2] == ele3) t3 = true;
            }
            if(t1 && t2 && t3) return true;
        }
        // if(t1 && t2 && t3) return true;
        return false;

    }
}