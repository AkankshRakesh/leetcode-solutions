class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long tot = (long) n * (n + 1)/2;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, n - 1);

        long inv = tot;

        for(int i = 0; i < n; i++){
            int ind = order[i];

            Integer start = tm.floorKey(ind);
            if(start == null) continue;
            int end = tm.get(start);

            if(ind < start || ind > end) continue;

            tm.remove(start);
            int len = end - start + 1;
            inv -= (long) len * (len + 1)/2;

            if(start <= ind - 1){
                int left = ind - start;
                tm.put(start, ind - 1);
                inv += (long) left * (left + 1) / 2;
            }

            if(ind + 1 <= end){
                int right = end - ind;
                tm.put(ind + 1, end);
                inv += (long) right * (right + 1) / 2;
            }

            long val = tot - inv;
            if(val >= k) return i;
        }
        return - 1;
    }
}