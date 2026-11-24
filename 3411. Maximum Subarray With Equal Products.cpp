class Solution {
public:
    double gcd(double a, double b) {
        if (b == 0) return a;
        if (a < b) return gcd(b, a);

        return gcd(b, fmod(a, b));
    }

    double lcm(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        return abs(a / gcd(a, b)) * abs(b);
    }

    int maxLength(vector<int>& nums) {
        int ans = 1;

        for (int i = 0; i < nums.size(); i++) {
            double lastGcd = nums[i];
            double lastLcm = nums[i];
            double prod = nums[i];

            for (int j = i + 1; j < nums.size(); j++) {
                prod *= nums[j];
                lastGcd = gcd(lastGcd, nums[j]);
                lastLcm = lcm(lastLcm, nums[j]);

                if (lastLcm * lastGcd == prod)
                    ans = max(ans, j - i + 1);
            }
        }

        return ans;
    }
};