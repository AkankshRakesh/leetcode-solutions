class Solution {
    public boolean check(HashSet<Integer> hs1, HashSet<Integer> hs2){
        if(hs1.size() < hs2.size()){
            for(Integer lang : hs1) if(hs2.contains(lang)) return true;
        }
        else{
            for(Integer lang : hs2) if(hs1.contains(lang)) return true;
        }
        
        return false;
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int people = languages.length;
        for(int i = 0; i < people; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j = 0; j < languages[i].length; j++) hs.add(languages[i][j]);
            hm.put(i + 1, hs);
        }

        HashSet<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int a = f[0], b = f[1];
            if (!check(hm.get(a), hm.get(b))) {
                needTeach.add(a);
                needTeach.add(b);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int ans = Integer.MAX_VALUE;

        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int p : needTeach)
                if (!hm.get(p).contains(lang)) count++;

            ans = Math.min(ans, count);
        }

        return ans;
    }
}