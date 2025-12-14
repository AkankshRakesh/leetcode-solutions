class Solution {
public:
    int MOD = 1000000007;

    int numberOfWays(string corridor) {
        int totalSeats = 0;
        for (char corr : corridor)
            if (corr == 'S') totalSeats++;

        if (totalSeats % 2 != 0 || totalSeats == 0) return 0;
        if (totalSeats == 2) return 1;

        long long ans = 1;
        int curr = 0;
        bool divideCountStart = false;
        int currSeat = 0;

        for (char item : corridor) {
            if (item == 'S') {
                if (divideCountStart) {
                    ans = (ans * (curr + 1)) % MOD;
                    curr = 0;
                    divideCountStart = false;
                }
                currSeat++;
                if (currSeat % 2 == 0 && currSeat != 0)
                    divideCountStart = true;
            }
            else if (divideCountStart) {
                curr++;
            }
        }

        return (int)ans;
    }
};
