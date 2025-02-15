class Solution {

    public boolean canPartition(int num, int target) {
        if (target < 0 || num < target) {
            return false;
        }

        if (num == target) {
            return true;
        }

        return (
            canPartition(num / 10, target - (num % 10)) ||
            canPartition(num / 100, target - (num % 100)) ||
            canPartition(num / 1000, target - (num % 1000))
        );
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;

        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;
            if(currentNum % 9 != 0 && currentNum % 9 != 1) continue;
            if (canPartition(squareNum, currentNum)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }
}
