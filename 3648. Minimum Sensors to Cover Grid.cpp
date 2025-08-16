class Solution {
public:
    int minSensors(int n, int m, int k) {
        int dist = 2 * k + 1;
        int rows = (n + dist - 1) / dist;
        int cols = (m + dist - 1) / dist;
        return rows * cols;
    }
};