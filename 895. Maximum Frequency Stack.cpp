class FreqStack {
    struct Compare {
        bool operator()(const vector<int>& a, const vector<int>& b) {
            if (a[1] != b[1]) return a[1] < b[1];
            return a[2] < b[2];
        }
    };
    priority_queue<vector<int>, vector<vector<int>>, Compare> pq;
    unordered_map<int, int> hm;
    int time = 0;

public:
    FreqStack() {}

    void push(int val) {
        if (hm.find(val) == hm.end()) {
            pq.push({val, 1, time++});
            hm[val] = 1;
        } else {
            pq.push({val, hm[val] + 1, time++});
            hm[val]++;
        }
    }

    int pop() {
        while (hm[pq.top()[0]] != pq.top()[1]) pq.pop();
        hm[pq.top()[0]]--;
        int val = pq.top()[0];
        pq.pop();
        return val;
    }
};