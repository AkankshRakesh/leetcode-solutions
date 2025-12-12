class Solution {
public:
    vector<int> countMentions(int numberOfUsers, vector<vector<string>>& events) {

        sort(events.begin(), events.end(),
             [](const vector<string>& a, const vector<string>& b) {
                 int t1 = stoi(a[1]);
                 int t2 = stoi(b[1]);
                 if (t1 != t2) return t1 < t2;
                 return (a[0] == "OFFLINE") ? true : false;
             });

        vector<int> mentions(numberOfUsers, 0);
        unordered_set<int> onlineUsers;
        vector<int> offlineUsers(numberOfUsers, 0);

        for (int i = 0; i < numberOfUsers; i++) {
            onlineUsers.insert(i);
        }

        for (auto& event : events) {
            int currTime = stoi(event[1]);

            for (int i = 0; i < numberOfUsers; i++) {
                if (!onlineUsers.count(i) && offlineUsers[i] + 60 <= currTime)
                    onlineUsers.insert(i);
            }

            if (event[0] == "MESSAGE") {

                if (event[2] == "ALL") {
                    for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
                }

                else if (event[2] == "HERE") {
                    for (int i = 0; i < numberOfUsers; i++)
                        if (onlineUsers.count(i)) mentions[i]++;
                }

                else {
                    string str = event[2];
                    int curr = 0;

                    for (char c : str) {
                        if (c >= '0' && c <= '9') {
                            curr = curr * 10 + (c - '0');
                        } 
                        else if (c == ' ') {
                            mentions[curr]++;
                            curr = 0;
                        }
                    }

                    mentions[curr]++; // last user
                }
            }

            else { // OFFLINE
                int id = stoi(event[2]);
                onlineUsers.erase(id);
                offlineUsers[id] = stoi(event[1]);
            }
        }

        return mentions;
    }
};
