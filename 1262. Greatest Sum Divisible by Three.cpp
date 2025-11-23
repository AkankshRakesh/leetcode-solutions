class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int sum = 0;
        int firstFor1 = -1;
        int secondFor1 = -1;
        int firstFor2 = -1;
        int secondFor2 = -1;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                if (firstFor1 == -1) firstFor1 = num;
                else {
                    if (firstFor1 > num) {
                        secondFor1 = firstFor1;
                        firstFor1 = num;
                    }
                    else if (secondFor1 == -1 || secondFor1 > num) {
                        secondFor1 = num;
                    }
                }
            }
            else if (num % 3 == 2) {
                if (firstFor2 == -1) firstFor2 = num;
                else {
                    if (firstFor2 > num) {
                        secondFor2 = firstFor2;
                        firstFor2 = num;
                    }
                    else if (secondFor2 == -1 || secondFor2 > num) {
                        secondFor2 = num;
                    }
                }
            }
        }

        if (sum % 3 == 1) {
            if (firstFor1 == -1) return sum - firstFor2 - secondFor2;
            else if (secondFor2 != -1) return max(sum - firstFor1, sum - firstFor2 - secondFor2);
            return sum - firstFor1;
        }
        else if (sum % 3 == 2) {
            if (firstFor2 == -1) return sum - firstFor1 - secondFor1;
            else if (secondFor1 != -1) return max(sum - firstFor2, sum - secondFor1 - firstFor1);
            return sum - firstFor2;
        }

        return sum;
    }
};
