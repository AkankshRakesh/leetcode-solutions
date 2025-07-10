class Solution {
public:
    bool winnerOfGame(const std::string& colors) {
        int aMoves = 0, bMoves = 0;
        int countA = 0, countB = 0;

        for (char c : colors) {
            if (c == 'A') {
                if (countB >= 3) bMoves += (countB - 2);
                countB = 0;
                countA++;
            } else {
                if (countA >= 3) aMoves += (countA - 2);
                countA = 0;
                countB++;
            }
        }

        if (countA >= 3) aMoves += (countA - 2);
        if (countB >= 3) bMoves += (countB - 2);

        return aMoves > bMoves;
    }
};
