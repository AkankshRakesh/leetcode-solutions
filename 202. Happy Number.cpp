class Solution {
public:
    bool isHappy(int n) {
        if(n == 1) return true;

        unordered_set<int> hs;
        while(hs.find(n) == hs.end()) {
            if(n == 1) return true;

            hs.insert(n);
            int next = 0;
            while(n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }

            n = next;
        }

        return false;
    }
};
