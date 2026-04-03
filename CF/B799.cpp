int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> prices(n), front(n), back(n);
    vector<bool> used(n, false);

    for (int i = 0; i < n; i++) cin >> prices[i];
    for (int i = 0; i < n; i++) cin >> front[i];
    for (int i = 0; i < n; i++) cin >> back[i];

    unordered_map<int, priority_queue<int, vector<int>, function<bool(int,int)>>> hm;

    auto cmp = [&](int a, int b) { return prices[a] > prices[b]; };

    for (int i = 0; i < n; i++) {
        if (hm.find(front[i]) == hm.end()) {
            hm[front[i]] = priority_queue<int, vector<int>, function<bool(int,int)>>(cmp);
        }
        hm[front[i]].push(i);

        if (hm.find(back[i]) == hm.end()) {
            hm[back[i]] = priority_queue<int, vector<int>, function<bool(int,int)>>(cmp);
        }
        hm[back[i]].push(i);
    }

    int queries;
    cin >> queries;
    vector<int> q(queries);
    for (int i = 0; i < queries; i++) cin >> q[i];
    vector<int> ans(queries);

    for (int i = 0; i < queries; i++) {
        if (hm.find(q[i]) == hm.end()) {
            ans[i] = -1;
        } else {
            auto &pq = hm[q[i]];
            while (!pq.empty() && used[pq.top()]) pq.pop();
            if (pq.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = prices[pq.top()];
                used[pq.top()] = true;
            }
        }
    }

    for (int val : ans) cout << val << " ";
    cout << "\n";

    return 0;
}