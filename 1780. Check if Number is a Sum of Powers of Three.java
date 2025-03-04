class Solution {

    public boolean checkPowersOfThree(int n) {
        return checkPowersOfThreeHelper(0, n);
    }

    public boolean checkPowersOfThreeHelper(int power, int n) {
        if (n == 0) return true;

        if (Math.pow(3, power) > n) return false;

        boolean addPower = checkPowersOfThreeHelper(
            power + 1,
            n - (int) Math.pow(3, power)
        );

        boolean skipPower = checkPowersOfThreeHelper(power + 1, n);

        return addPower || skipPower;
    }
}