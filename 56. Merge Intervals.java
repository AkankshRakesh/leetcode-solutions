class Solution {
    class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] invs) {
        Arrays.sort(invs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        List<Pair> merged = new ArrayList<>();
        merged.add(new Pair(invs[0][0], invs[0][1]));

        for (int i = 1; i < invs.length; i++) {
            Pair last = merged.get(merged.size() - 1);
            if (last.end >= invs[i][0]) {
                last.end = Math.max(last.end, invs[i][1]);
            } else {
                merged.add(new Pair(invs[i][0], invs[i][1]));
            }
        }

        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ans[i][0] = merged.get(i).start;
            ans[i][1] = merged.get(i).end;
        }

        return ans;
    }
}
