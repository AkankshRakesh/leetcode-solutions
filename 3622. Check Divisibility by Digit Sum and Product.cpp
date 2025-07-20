class Solution {
public:
    bool checkDivisibility(int n) {
        int prod = 1, sum = 0;
        int temp = n;
        while (temp != 0) {
            int lastDig = temp % 10;
            prod *= lastDig;
            sum += lastDig;
            temp /= 10;
        }
        if (prod + sum == 0) return false;
        return (n % (prod + sum) == 0);
    }
};
