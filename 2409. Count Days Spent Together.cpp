class Solution {
public:
    int getDay(string str) {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = 0;
        month += str[0] - '0';
        month *= 10;
        month += str[1] - '0';

        int day = 0;
        day += str[3] - '0';
        day *= 10;
        day += str[4] - '0';

        int ans = 0;

        int index = 0;
        while (index < month) {
            if (index + 1 == month) ans += day;
            else ans += days[index];

            index++;
        }

        return ans;
    }

    int countDaysTogether(string arriveAlice, string leaveAlice,
                          string arriveBob, string leaveBob) {
        int aa = getDay(arriveAlice);
        int la = getDay(leaveAlice);
        int ab = getDay(arriveBob);
        int lb = getDay(leaveBob);

        if (aa < ab) {
            if (la < ab) return 0;
            return min(la, lb) - max(aa, ab) + 1;
        }

        if (lb < aa) return 0;
        return min(la, lb) - max(aa, ab) + 1;
    }
};