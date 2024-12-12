class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        priority_queue<int> pq(gifts.begin(), gifts.end());

        for (int i = 0; i < k; i++) {
            int maxElement = pq.top();
            pq.pop();
            pq.push(sqrt(maxElement));
        }

        long long numberOfRemainingGifts = 0;
        while (!pq.empty()) {
            numberOfRemainingGifts += pq.top();
            pq.pop();
        }
        return numberOfRemainingGifts;
    }
};