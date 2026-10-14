class Solution {
public:
    string maxSumOfSquares(int n, int sum) {
        string sb;
        while (sum != 0 && n != 0) {
            if (sum >= 9) {
                sum -= 9;
                sb.append("9");
            }
            else {
                sb.append(to_string(sum));
                sum = 0;
            }
            n--;
        }

        if (sum != 0) return "";
        while (n != 0) {
            sb.append("0");
            n--;
        }

        return sb;
    }
};