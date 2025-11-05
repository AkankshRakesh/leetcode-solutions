class Solution {
    static class Pair {
        long freq;
        long val;
        Pair(long f, long v) { freq = f; val = v; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return freq == p.freq && val == p.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(freq, val);
        }
    }

    private static final Comparator<Pair> comp = (a, b) -> {
        if (a.freq != b.freq) return Long.compare(a.freq, b.freq);
        return Long.compare(a.val, b.val);
    };

    private HashMap<Long, Long> freq;
    private TreeSet<Pair> top, rest;
    private long topSum;
    private int X;

    private void balance() {
        while (top.size() < X && !rest.isEmpty()) {
            Pair p = rest.pollLast();
            top.add(p);
            topSum += p.freq * p.val;
        }

        while (top.size() > X) {
            Pair p = top.pollFirst();
            topSum -= p.freq * p.val;
            rest.add(p);
        }

        while (!rest.isEmpty() && !top.isEmpty() && comp.compare(rest.last(), top.first()) > 0) {
            Pair r = rest.pollLast();
            Pair t = top.pollFirst();
            topSum += r.freq * r.val - t.freq * t.val;
            top.add(r);
            rest.add(t);
        }
    }

    private void add(long num) {
        long oldFreq = freq.getOrDefault(num, 0L);
        Pair old = new Pair(oldFreq, num);

        if (top.remove(old)) {
            topSum -= old.freq * old.val;
        } else {
            rest.remove(old);
        }

        long newFreq = oldFreq + 1;
        freq.put(num, newFreq);
        rest.add(new Pair(newFreq, num));

        balance();
    }

    private void remove(long num) {
        long oldFreq = freq.get(num);
        Pair old = new Pair(oldFreq, num);

        if (top.remove(old)) {
            topSum -= old.freq * old.val;
        } else {
            rest.remove(old);
        }

        long newFreq = oldFreq - 1;
        if (newFreq > 0) {
            freq.put(num, newFreq);
            rest.add(new Pair(newFreq, num));
        } else {
            freq.remove(num);
        }

        balance();
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        freq = new HashMap<>();
        top = new TreeSet<>(comp);
        rest = new TreeSet<>(comp);
        topSum = 0;
        X = x;

        long[] ans = new long[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        ans[0] = topSum;

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = topSum;
        }

        return ans;
    }
}
