class Solution {
    struct Triplet {
        char ch;
        int freq;
        int time;
        Triplet(char c, int f, int t) : ch(c), freq(f), time(t) {}
    };

public:
    int leastInterval(vector<char>& tasks, int n) {
        auto cmp = [](const Triplet& a, const Triplet& b) {
            if (a.time != b.time) return a.time > b.time;
            return a.freq < b.freq; 
        };

        priority_queue<Triplet, vector<Triplet>, decltype(cmp)> pq(cmp);

        unordered_map<char, int> hm;
        for (char ch : tasks) hm[ch]++;

        for (auto& ele : hm) {
            pq.emplace(ele.first, ele.second, 0);
        }

        int currTime = 0;
        while (!pq.empty()) {
            Triplet tp = pq.top(); pq.pop();
            if (tp.time > currTime) currTime = tp.time;

            if (tp.freq != 1) {
                pq.emplace(tp.ch, tp.freq - 1, tp.time + n + 1);
            }

            currTime++;
        }

        return currTime;
    }
};
 