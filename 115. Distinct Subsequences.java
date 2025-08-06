class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return first == p.first && second == p.second;
        }

        @Override
        public int hashCode() {
            return 31 * first + second;
        }
    }
    public int count(String s, String t, HashMap<Pair, Integer> hm, int i, int j, int n, int m){
        if (j == m) return 1;        
        if (i == n) return 0;

        Pair p = new Pair(i, j);
        if(hm.containsKey(p)) return hm.get(p);

        int c = 0;
        if(s.charAt(i) == t.charAt(j)){
            c = count(s, t, hm, i + 1, j + 1, n, m) + count(s, t, hm, i + 1, j, n, m);
        }
        else{
            c = count(s, t, hm, i + 1, j, n, m);
        }
        hm.put(p, c);
        return c;
    }
    public int numDistinct(String s, String t) {
        HashMap<Pair, Integer> hm = new HashMap<>();

        return count(s, t, hm, 0, 0, s.length(), t.length());
    }
}