class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        Integer[] capArray = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            capArray[i] = capacity[i];
        }

        Arrays.sort(capArray, Collections.reverseOrder());

        int need = 0;
        while (sum > 0) {
            sum -= capArray[need];
            need += 1;
        }

        return need;
    }
}