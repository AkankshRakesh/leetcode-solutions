class BusBooking {
    vector<vector<int>> seats;
    int totalTime = 0;
    int minTime = 0;

public:
    BusBooking(int n) {
        seats = vector<vector<int>>(n + 1, vector<int>(4, 0));
    }

    void toggle(string seat) {
        int sn = seat[0] - 'A';
        int row = 0;

        for (int i = 1; i < seat.length(); i++) {
            row *= 10;
            row += seat[i] - '0';
        }

        if (seats[row][sn] != 0) {
            totalTime -= seats[row][sn];
            minTime--;
            seats[row][sn] = 0;
        }
        else if ((sn == 0 && seats[row][1] != 0) ||
                 (sn == 3 && seats[row][2] != 0)) {
            totalTime += 3;
            minTime++;
            seats[row][sn] = 3;
        }
        else {
            totalTime++;
            minTime++;
            seats[row][sn] = 1;
        }
    }

    int getTotalTime() {
        return totalTime;
    }

    int getMinTime() {
        return minTime;
    }
};