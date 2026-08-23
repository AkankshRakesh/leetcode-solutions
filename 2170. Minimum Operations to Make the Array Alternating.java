class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenFreq.put(nums[i], evenFreq.getOrDefault(nums[i], 0) + 1);
            } else {
                oddFreq.put(nums[i], oddFreq.getOrDefault(nums[i], 0) + 1);
            }
        }

        int[] evenTop = getTopTwo(evenFreq);
        int[] oddTop = getTopTwo(oddFreq);

        int evenCount = (nums.length + 1) / 2;
        int oddCount = nums.length / 2;

        if (evenTop[0] != oddTop[0]) {
            return (evenCount - evenTop[1])
                 + (oddCount - oddTop[1]);
        }

        int option1 = (evenCount - evenTop[1])
                    + (oddCount - oddTop[3]);

        int option2 = (evenCount - evenTop[3])
                    + (oddCount - oddTop[1]);

        return Math.min(option1, option2);
    }

    // {value1, frequency1, value2, frequency2}
    private int[] getTopTwo(Map<Integer, Integer> freq) {
        int firstValue = -1;
        int firstFreq = 0;

        int secondValue = -1;
        int secondFreq = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count > firstFreq) {
                secondValue = firstValue;
                secondFreq = firstFreq;

                firstValue = value;
                firstFreq = count;
            } else if (count > secondFreq) {
                secondValue = value;
                secondFreq = count;
            }
        }

        return new int[] {
            firstValue, firstFreq,
            secondValue, secondFreq
        };
    }
}