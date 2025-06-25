class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        // Max-heap priority queue
        priority_queue<int> pq;

        // Insert all stones into the heap
        for (int stone : stones) {
            pq.push(stone);
        }

        // Continue until 0 or 1 stone remains
        while (pq.size() > 1) {
            int y = pq.top(); pq.pop();
            int x = pq.top(); pq.pop();

            if (y != x) {
                pq.push(y - x);
            }
        }

        return pq.empty() ? 0 : pq.top();
    }
};
