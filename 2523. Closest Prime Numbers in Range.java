class Solution {

    public int[] closestPrimes(int left, int right) {
        int[] sieveArray = sieve(right);

        List<Integer> primeNumbers = new ArrayList<>(); 
        for (int num = left; num <= right; num++) {
            if (sieveArray[num] == 1) {
                primeNumbers.add(num);
            }
        }

        if (primeNumbers.size() < 2) return new int[] { -1, -1 }; 

        int minDifference = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        Arrays.fill(closestPair, -1);

        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference =
                primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair[0] = primeNumbers.get(index - 1);
                closestPair[1] = primeNumbers.get(index);
            }
        }

        return closestPair;
    }

    public int[] sieve(int upperLimit) {
        int[] sieve = new int[upperLimit + 1];
        Arrays.fill(sieve, 1);

        sieve[0] = 0;
        sieve[1] = 0;

        for (int number = 2; number * number <= upperLimit; number++) {
            if (sieve[number] == 1) {
                for (
                    int multiple = number * number;
                    multiple <= upperLimit;
                    multiple += number
                ) {
                    sieve[multiple] = 0;
                }
            }
        }
        return sieve;
    }
}