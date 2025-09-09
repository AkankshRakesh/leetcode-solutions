class Solution {
public:
    void reverse(vector<int>& a) {
        int left = 0;
        int right = (int)a.size() - 1;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    vector<int> topKSumPairs(vector<int>& a, vector<int>& b, int k) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        reverse(a);
        reverse(b);

        auto cmp = [](const array<int,3>& first, const array<int,3>& second){
            return first[0] < second[0]; // max-heap by sum
        };
        priority_queue<array<int,3>, vector<array<int,3>>, decltype(cmp)> pq(cmp);
        unordered_set<string> hs;

        pq.push({a[0] + b[0], 0, 0});
        hs.insert("0-0");
        int n = (int)a.size();
        vector<int> arr;

        while (!pq.empty() && k != 0) {
            auto top = pq.top();
            pq.pop();
            arr.push_back(top[0]);

            int i = top[1];
            int j = top[2];

            string first = to_string(i + 1) + "-" + to_string(j);
            string second = to_string(i) + "-" + to_string(j + 1);

            if (i + 1 < n && hs.find(first) == hs.end()) {
                pq.push({a[i + 1] + b[j], i + 1, j});
                hs.insert(first);
            }
            if (j + 1 < n && hs.find(second) == hs.end()) {
                pq.push({a[i] + b[j + 1], i, j + 1});
                hs.insert(second);
            }

            k--;
        }

        return arr;
    }
};
