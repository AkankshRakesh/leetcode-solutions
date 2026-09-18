class Solution {
    private int[] getInterval(String s, char ch, int[][] intervals){
        int l = -1, r = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch){
                if(l == -1){
                    l = i;
                    r = i;
                }
                else r = i;
            }
        }

        for (int i = l; i <= r; i++) {
            int c = s.charAt(i) - 'a';

            if (intervals[c][0] < l)
                return new int[]{-1, -1};

            r = Math.max(r, intervals[c][1]);
        }

        return new int[]{l, r};
    }

    private int nextInterval(int[][] intervals, int index, int end){
        for(int i = index + 1; i < 26; i++){
            if(intervals[i][0] > end) return i;
        }

        return -1;
    }

    public List<String> maxNumOfSubstrings(String s) {

        int[][] original = new int[26][2];
        for(int i = 0; i < 26; i++) {
            original[i][0] = -1;
            original[i][1] = -1;

            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == (char)(i + 'a')) {
                    if(original[i][0] == -1)
                        original[i][0] = j;

                    original[i][1] = j;
                }
            }
        }

        int[][] intervals = new int[26][2];
        for(int i = 0; i < 26; i++) {
            intervals[i] = new int[]{-1, -1};
            
            if(original[i][0] != -1) {
                intervals[i] = getInterval(s,(char)(i + 'a'), original);
            }
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        ArrayList<Integer> ranges = new ArrayList<>();
        int end = -1;

        for(int i = 0; i < 26; i++){
            if(intervals[i][0] == -1) continue;
            if(intervals[i][0] > end) {
                ranges.add(i);
                end = intervals[i][1];
            }
        }

        List<String> ans = new ArrayList<>();
        for(int index : ranges){
            int left = intervals[index][0];
            int right = intervals[index][1];

            StringBuilder sb = new StringBuilder();
            for(int i = left; i <= right; i++) sb.append(s.charAt(i));
            ans.add(sb.toString());
        }

        return ans;
    }
}