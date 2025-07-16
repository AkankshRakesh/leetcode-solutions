class Solution {
    public int maximumLength(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        int alternateCount = 0;
        int parity = -1;
        
        for (int i : nums) {
            if (i % 2 == 0) {
                evenCount++;
                if (parity == 1 || parity == -1) {
                    alternateCount++;
                }
            } else {
                oddCount++;
                if (parity == 0 || parity == -1) {
                    alternateCount++;
                }
            }

            parity = i % 2;
        }

        return Math.max(alternateCount, Math.max(evenCount, oddCount));
    }
}