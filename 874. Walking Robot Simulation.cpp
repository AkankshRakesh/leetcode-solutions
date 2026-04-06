class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx = 0, dy = 1;
        int x = 0, y = 0;
        unordered_set<string> hs;
        for (const auto& obst : obstacles) {
            hs.insert(to_string(obst[0]) + " " + to_string(obst[1]));
        }

        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                int temp = dy;
                dy = -dx;
                dx = temp;
            }
            else if (command == -2) {
                int temp = dy;
                dy = dx;
                dx = -temp;
            }
            else {
                while (command != 0) {
                    int nextX = x + dx;
                    int nextY = y + dy;
                    if (hs.count(to_string(nextX) + " " + to_string(nextY))) break;
                    x = nextX;
                    y = nextY;
                    command--;
                }
            }
            ans = max(ans, (x * x) + (y * y));
        }

        return ans;
    }
};