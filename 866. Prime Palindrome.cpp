class Solution {
public:
    bool isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    int primePalindrome(int n) {
        if (n < 12) {
            while (true) {
                if (isPrime(n)) return n;
                n++;
            }
        } else {
            for (int i = 1; i < 100000; i++) {
                string s = to_string(i);
                string rev = s;
                reverse(rev.begin(), rev.end());
                string palStr = s + rev.substr(1);
                int ele = stoi(palStr);
                if (ele >= n && isPrime(ele)) return ele;
            }
        }
        return 0; 
    }
};
