class Solution {
    public int findCenter(int[][] edges) {
        int[] u = edges[0];
        int[] v = edges[1];

        if(u[0] == v[0] || u[0] == v[1]) return u[0];
        return u[1];
    }
}