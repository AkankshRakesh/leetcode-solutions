class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for(int i = 0; i < commands.size(); i++){
            if(commands.get(i).charAt(0) == 'U') x--;
            else if(commands.get(i).charAt(0) == 'D') x++;
            else if(commands.get(i).charAt(0) == 'L') y--;
            else if(commands.get(i).charAt(0) == 'R') y++;
        }
        
        return (x * n) + y; 
    }
}