class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        int n = points.length;

        for(int i = 0; i < n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            if(!hm.containsKey(dist)){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hm.put(dist, arr);
            }
            else hm.get(dist).add(i);
        }
        int[][] ans = new int[k][2];
        int ind = 0;
        for(ArrayList<Integer> index: hm.values()){
            int size = index.size();
            for(int i = 0; i < size && ind < k; i++){
                int[] temp = points[index.get(i)];
                ans[ind] = temp;
                ind++;
            }
            if(ind >= k) break;
        }

        return ans;
    }
}