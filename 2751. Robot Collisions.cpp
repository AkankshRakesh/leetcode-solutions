class Solution {
public:
    struct Robot {
        int position;
        int health;
        char direction;
        Robot(int position, int health, char direction) 
            : position(position), health(health), direction(direction) {}
    };

    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, const string& directions) {
        stack<Robot> st;
        vector<Robot> arr;
        int n = positions.size();
        for (int i = 0; i < n; i++) {
            arr.emplace_back(positions[i], healths[i], directions[i]);
        }
        sort(arr.begin(), arr.end(), [](const Robot& a, const Robot& b) {
            return a.position < b.position;
        });

        for (int i = 0; i < n; i++) {
            Robot& curr = arr[i];
            if (curr.direction == 'R') {
                st.push(curr);
                continue;
            }
            while (!st.empty() && st.top().direction == 'R') {
                Robot top = st.top();
                st.pop();
                if (top.health > curr.health) {
                    st.push(Robot(top.position, top.health - 1, top.direction));
                    curr.health = 0;
                    break;
                } else if (top.health == curr.health) {
                    curr.health = 0;
                    break;
                }
                curr.health--;
            }
            if (curr.health > 0) st.push(Robot(curr.position, curr.health, curr.direction));
        }

        unordered_map<int, int> hm;
        while (!st.empty()) {
            Robot top = st.top();
            st.pop();
            hm[top.position] = top.health;
        }

        vector<int> ans;
        for (int position : positions) {
            if (hm.find(position) != hm.end()) {
                ans.push_back(hm[position]);
            }
        }

        return ans;
    }
};