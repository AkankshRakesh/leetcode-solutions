class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dx = 0, dy = 1;
        int x = 0, y = 0;
        HashSet<String> hs = new HashSet<>();
        for(int[] obst : obstacles){
            hs.add(obst[0] + " " + obst[1]);
        }

        int ans = 0;
        for(int command : commands){
            if(command == -1){
                int temp = dy;
                dy = -dx;
                dx = temp;
            }
            else if(command == -2){
                int temp = dy;
                dy = dx;
                dx = -temp;
            }
            else{
                while(command != 0){
                    int nextX = x + dx;
                    int nextY = y + dy;
                    if(hs.contains(nextX + " " + nextY)) break;
                    x = nextX;
                    y = nextY;
                    command--;
                }
            }
            ans = Math.max(ans, (x * x) + (y * y));
        }

        return ans;
    }
}