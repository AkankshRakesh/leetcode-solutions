class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; 
        for (int i = 1; i <= n; i++) {
            int digSum = digitSum(i);
            count[digSum]++;
        }

        int maxSize = 0, maxGroups = 0;
        for (int c : count) {
            if (c > maxSize) {
                maxSize = c;
                maxGroups = 1;
            } else if (c == maxSize) {
                maxGroups++;
            }
        }
        return maxGroups;
    }
    private int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}