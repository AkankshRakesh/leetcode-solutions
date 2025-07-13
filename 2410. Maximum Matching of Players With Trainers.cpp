class Solution {
public:
    int matchPlayersAndTrainers(std::vector<int>& players, std::vector<int>& trainers) {
        int n = players.size();
        int m = trainers.size();

        std::sort(players.begin(), players.end());
        std::sort(trainers.begin(), trainers.end());

        int count = 0;
        int index = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (index < 0) break;
            if (players[i] <= trainers[index]) {
                count++;
                index--;
            }
        }

        return count;
    }
};
