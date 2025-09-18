class Solution {
    struct Pair {
        int start;
        int finish;
        Pair(int s, int f) : start(s), finish(f) {}
    };

    struct cmp {
        bool operator()(const Pair& a, const Pair& b) const {
            if (a.finish != b.finish)
                return a.finish > b.finish;
            return a.start > b.start;
        }
    };

public:
    int activitySelection(vector<int>& start, vector<int>& finish) {
        priority_queue<Pair, vector<Pair>, cmp> pq;
        for (size_t i = 0; i < start.size(); i++) {
            pq.push(Pair(start[i], finish[i]));
        }

        int count = 0;
        int time = 0;
        while (!pq.empty()) {
            Pair p = pq.top();
            pq.pop();
            if (p.start > time) {
                count++;
                time = p.finish;
            }
        }
        return count;
    }
};
