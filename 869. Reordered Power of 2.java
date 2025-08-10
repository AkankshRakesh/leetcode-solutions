class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = Integer.toString(n);
        char[] digits = s.toCharArray();
        Arrays.sort(digits);
        boolean[] used = new boolean[digits.length];
        return backtrack(digits, used, new StringBuilder());
    }

    private boolean backtrack(char[] digits, boolean[] used, StringBuilder current) {
        if (current.length() == digits.length) {
            if (current.charAt(0) == '0') return false;
            int val = Integer.parseInt(current.toString());
            return isPowerOfTwo(val);
        }

        for (int i = 0; i < digits.length; i++) {
            if (i > 0 && digits[i] == digits[i-1] && !used[i-1]) continue;
            if (!used[i]) {
                used[i] = true;
                current.append(digits[i]);
                if (backtrack(digits, used, current)) return true;
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
        return false;
    }

    private boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }
}
