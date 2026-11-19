class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        if (nums.size() == 3) return 0;

        int sm = INT_MAX, sSm = INT_MAX, tSm = INT_MAX;
        int la = INT_MIN, sLa = INT_MIN, tLa = INT_MIN;

        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];

            if (num < sm) {
                tSm = sSm;
                sSm = sm;
                sm = num;
            }
            else if (num < sSm) {
                tSm = sSm;
                sSm = num;
            }
            else if (num < tSm) {
                tSm = num;
            }

            if (num > la) {
                tLa = sLa;
                sLa = la;
                la = num;
            }
            else if (num > sLa) {
                tLa = sLa;
                sLa = num;
            }
            else if (num > tLa) {
                tLa = num;
            }
        }

        return min(tLa - sm, min(la - tSm, sLa - sSm));
    }
};