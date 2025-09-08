// User function Template for Java

class Solution {
    static int distinct(int matrix[][], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++) hm.put(matrix[0][i], hm.getOrDefault(matrix[0][i], 0) + 1);
        
        for(int i = 1; i < n; i++){
            HashMap<Integer, Integer> currHm = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(!hm.containsKey(matrix[i][j])) continue;
                if(hm.get(matrix[i][j]) == 1) hm.remove(matrix[i][j]);
                else hm.put(matrix[i][j], hm.get(matrix[i][j]) - 1);
                
                currHm.put(matrix[i][j], currHm.getOrDefault(matrix[i][j], 0) + 1);
            }
            
            hm = new HashMap<>(currHm);
        }
        
        return hm.size();
    }
}