class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        int north = 0, south = 0, east = 0, west = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }
            int yAxis = Math.min(Math.min(north, south), k);
            int xAxis = Math.min(Math.min(east, west), k - yAxis);

            ans = Math.max(ans, Math.abs(north - south) + yAxis * 2 + Math.abs(east - west) + xAxis * 2);
        }
        return ans;
    }
}