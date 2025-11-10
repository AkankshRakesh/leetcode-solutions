class Solution {

    public int minOperations(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.peek() > a)  s.pop();
            if (a == 0) continue;
            if (s.isEmpty() || s.peek() < a) {
                res++;
                s.push(a);
            }
        }
        return res;
    }
}