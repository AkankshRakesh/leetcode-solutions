class Solution {

    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> r = new ArrayList<>();
        for (int[] res : restrictions) {
            r.add(new int[] { res[0], res[1] });
        }

        r.add(new int[] { 1, 0 });
        r.sort((a, b) -> Integer.compare(a[0], b[0]));
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[] { n, n - 1 });
        }

        int m = r.size();

        for (int i = 1; i < m; ++i) {
            int dist = r.get(i)[0] - r.get(i - 1)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
        }

        for (int i = m - 2; i >= 0; --i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
            ans = Math.max(ans, best);
        }

        return ans;
    }
}