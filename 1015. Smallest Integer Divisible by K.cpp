class Solution {
public:
    int smallestRepunitDivByK(int k) {
        int count = 1;
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int curr = 1;
        unordered_set<int> hs;

        while (curr != 0) {
            if (curr % k == 0) break;
            int nextVal = curr * 10 + 1;
            curr = nextVal % k;
            count++;
            if (hs.count(curr)) return -1;
            hs.insert(curr);
        }

        return count;
    }
};
