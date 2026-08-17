class Solution {
    public long maximumValue(int n, int s, int m) {
        long increases = n / 2;
        long decreases = (n - 2) / 2;

        return (long) s + increases * m - decreases;
    }
}