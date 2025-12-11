class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, int[]> xAxis = new HashMap<>();
        HashMap<Integer, int[]> yAxis = new HashMap<>();
        for(int i = 0; i < buildings.length; i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            if(xAxis.containsKey(x)){
                int[] coords = xAxis.get(x);
                coords[0] = Math.min(coords[0], y);
                coords[1] = Math.max(coords[1], y);
            }
            else{
                int[] coords = new int[2];
                coords[0] = y;
                coords[1] = y;
                xAxis.put(x, coords);
            }
            if(yAxis.containsKey(y)){
                int[] coords = yAxis.get(y);
                coords[0] = Math.min(coords[0], x);
                coords[1] = Math.max(coords[1], x);
            }
            else{
                int[] coords = new int[2];
                coords[0] = x;
                coords[1] = x;
                yAxis.put(y, coords);
            }
        }

        int ans = 0;
        for(int[] coords : buildings){
            int x = coords[0];
            int y = coords[1];
            int[] xCoords = xAxis.get(x);
            int[] yCoords = yAxis.get(y);
            if(xCoords[0] != y && xCoords[1] != y && yCoords[0] != x && yCoords[1] != x) ans++; 
        }

        return ans;
    }
}