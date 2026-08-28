class Solution {

    public boolean check(String prefix, String target, int[] freq, char odd) {
        int n = target.length();
        int half = n / 2;

        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != target.charAt(i)) {
                return prefix.charAt(i) > target.charAt(i);
            }
        }

        int[] copy = freq.clone();

        StringBuilder left = new StringBuilder(prefix);

        for (int pos = prefix.length(); pos < half; pos++) {
            int c = 127;

            while (c >= 0 && copy[c] < 2) {
                c--;
            }

            if (c < 0) {
                break;
            }

            copy[c] -= 2;
            left.append((char)c);

            if (left.charAt(pos) > target.charAt(pos)) {
                return true;
            }

            if (left.charAt(pos) < target.charAt(pos)) {
                return false;
            }
        }

        if ((n & 1) == 1 && odd != '0') {
            char targetMiddle = target.charAt(half);

            if (odd > targetMiddle) return true;
            if (odd < targetMiddle) return false;
        }

        for (int i = half - 1; i >= 0; i--) {
            char a = left.charAt(i);
            char b = target.charAt(n - 1 - i);

            if (a > b) return true;
            if (a < b) return false;
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        if (n == 1) {
            return s.compareTo(target) > 0 ? s : "";
        }

        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        char odd = '0';

        for (int i = 0; i < 128; i++) {
            if ((freq[i] & 1) == 1) {
                if (odd != '0') {
                    return "";
                }

                odd = (char)i;
            }
        }

        int half = n / 2;

        StringBuilder prefix = new StringBuilder();

        while (prefix.length() < half) {

            boolean found = false;

            for (int c = 0; c < 128; c++) {

                if (freq[c] < 2) {
                    continue;
                }

                freq[c] -= 2;
                prefix.append((char)c);

                if (check(prefix.toString(), target, freq, odd)) {
                    found = true;
                    break;
                }

                prefix.deleteCharAt(prefix.length() - 1);
                freq[c] += 2;
            }

            if (!found) {
                return "";
            }
        }

        StringBuilder ans = new StringBuilder(prefix);

        if (odd != '0') {
            ans.append(odd);
        }

        ans.append(new StringBuilder(prefix).reverse());

        return ans.toString();
    }
}