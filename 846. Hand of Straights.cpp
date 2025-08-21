class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        if (n % groupSize != 0) return false;

        map<int, int> tm;
        for (int card : hand) {
            tm[card]++;
        }

        while (!tm.empty()) {
            int ele = tm.begin()->first;

            for (int i = 0; i < groupSize; i++) {
                int card = ele + i;
                if (tm.find(card) == tm.end()) return false;

                if (tm[card] == 1) tm.erase(card);
                else tm[card]--;
            }
        }

        return true;
    }
};
