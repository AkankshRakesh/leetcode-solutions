class Solution {
public:
    bool isPalin(const string& s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s[left] != s[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    string breakPalindrome(string palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";

        bool foundNonA = false;
        string sb = "";

        for (int i = 0; i < n; i++) {
            if (palindrome[i] != 'a' && !foundNonA) {
                sb += 'a';
                foundNonA = true;
            } else {
                sb += palindrome[i];
            }
        }

        if (isPalin(sb) || !foundNonA) {
            sb = palindrome;
            sb[n - 1] = 'b';
        }

        return sb;
    }
};
