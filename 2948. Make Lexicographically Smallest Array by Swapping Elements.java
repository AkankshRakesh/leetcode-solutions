class Solution {
    class DSU {
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> indexes = new HashMap<>();

        public int find(int n) {
            if (parent.get(n) == n) return n;
            parent.put(n, find(parent.get(n)));
            return parent.get(n);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            // Merge py into px
            parent.put(py, px);

            indexes.get(px).addAll(indexes.get(py));
            indexes.remove(py);
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        DSU dsu = new DSU();
        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;

            dsu.parent.put(i, i);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);
            dsu.indexes.put(i, pq);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n - 1; i++) {
            int x = arr[i][0];
            int y = arr[i + 1][0];

            if (y - x <= limit) {
                dsu.union(arr[i][1], arr[i + 1][1]);
            }
        }

        int[] ans = new int[n];

        for (int[] pair : arr) {
            int num = pair[0];
            int index = pair[1];

            int parent = dsu.find(index);
            int targetIndex = dsu.indexes.get(parent).poll();

            ans[targetIndex] = num;
        }

        return ans;
    }
}