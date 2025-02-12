class Solution {
    public int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

    public int maximumSum(int[] nums) {
        PriorityQueue<Integer>[] digitSumGroups = new PriorityQueue[82];
        for (int i = 0; i < 82; i++) {
            digitSumGroups[i] = new PriorityQueue<Integer>();
        }

        int maxPairSum = -1;

        for (int number : nums) {
            int digitSum = calculateDigitSum(number);
            digitSumGroups[digitSum].add(number);

            if (digitSumGroups[digitSum].size() > 2) {
                digitSumGroups[digitSum].poll();
            }
        }

        for (PriorityQueue<Integer> minHeap : digitSumGroups) {
            if (minHeap.size() == 2) {
                int first = minHeap.poll();
                int second = minHeap.poll();
                maxPairSum = Math.max(maxPairSum, first + second);
            }
        }

        return maxPairSum;
    }
}