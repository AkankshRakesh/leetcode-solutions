class Solution {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void dfs(HashMap<Integer, ArrayList<Pair>> hm, int n, int ele, int eleCost, int[] minCosts, int currCost) {
        currCost += eleCost;
        minCosts[ele] = Math.min(minCosts[ele], currCost);

        ArrayList<Pair> neighbors = hm.get(ele);
        if (neighbors != null) {
            for (Pair pair : neighbors) {
                if (currCost + pair.y < minCosts[pair.x]) {
                    dfs(hm, n, pair.x, pair.y, minCosts, currCost);
                }
            }
        }

        currCost -= eleCost;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minCosts = new int[n + 1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int cost = times[i][2];

            if (!hm.containsKey(u)) {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(v, cost));
                hm.put(u, temp);
            } else
                hm.get(u).add(new Pair(v, cost));
        }

        dfs(hm, n, k, 0, minCosts, 0);

        int maxNum = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) maxNum = maxNum > minCosts[i] ? maxNum : minCosts[i];
        if(maxNum == Integer.MAX_VALUE) return -1;
        return maxNum;
    }
}