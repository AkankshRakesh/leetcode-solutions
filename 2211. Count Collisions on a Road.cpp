class Solution {
    public int countCollisions(String directions) {
        char lastCar = directions.charAt(0);
        int ans = 0;
        int rCount = (lastCar == 'R') ? 1 : 0;

        for(int i = 1; i < directions.length(); i++){
            char curr = directions.charAt(i);
            if(lastCar == 'R'){
                if(curr == 'R') rCount++;
                else if(curr == 'S' || curr == 'L'){
                    if(curr == 'S') ans += rCount;
                    else ans += rCount + 1;
                    rCount = 0;
                    lastCar = 'S';
                }
            }
            else if(lastCar == 'S'){
                if(curr == 'L') ans++;
                else if(curr == 'R'){
                    rCount = 1;
                    lastCar = 'R';
                }
            }
            else{
                if(curr == 'R') rCount = 1;
                lastCar = curr;
            }
            // System.out.println(lastCar + "-" + ans);
        }

        return ans;
    }
}