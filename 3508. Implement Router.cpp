class Router {
    class Data {
        int source, destination, timestamp;
        public Data(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }

    // times + counts + prefix sums if this doesn't work ima go crazy
    static class DestData {
        List<Integer> times = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
    }

    private Queue<Data> q = new LinkedList<>();
    private Map<Integer, DestData> destMap = new HashMap<>();
    private Set<String> seen = new HashSet<>();
    private int memory;

    public Router(int memoryLimit) {
        memory = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = destination + "#" + timestamp + "#" + source;
        if (seen.contains(key)) return false;
        seen.add(key);

        destMap.putIfAbsent(destination, new DestData());
        DestData dd = destMap.get(destination);

        int n = dd.times.size();
        if (n > 0 && dd.times.get(n - 1) == timestamp) {
            dd.counts.set(n - 1, dd.counts.get(n - 1) + 1);
            dd.prefix.set(n - 1, dd.prefix.get(n - 1) + 1);
        } else {
            dd.times.add(timestamp);
            dd.counts.add(1);
            int prevSum = n == 0 ? 0 : dd.prefix.get(n - 1);
            dd.prefix.add(prevSum + 1);
        }

        if (q.size() == memory) {
            Data removed = q.poll();
            String remKey = removed.destination + "#" + removed.timestamp + "#" + removed.source;
            seen.remove(remKey);
            removeFromDest(removed.destination, removed.timestamp);
        }

        q.offer(new Data(source, destination, timestamp));
        return true;
    }

    private void removeFromDest(int destination, int timestamp) {
        DestData dd = destMap.get(destination);
        int idx = Collections.binarySearch(dd.times, timestamp);
        if (idx < 0) return;

        dd.counts.set(idx, dd.counts.get(idx) - 1);
        for (int i = idx; i < dd.prefix.size(); i++) {
            dd.prefix.set(i, dd.prefix.get(i) - 1);
        }

        if (dd.counts.get(idx) == 0) {
            dd.times.remove(idx);
            dd.counts.remove(idx);
            dd.prefix.remove(idx);
        }
        if (dd.times.isEmpty()) destMap.remove(destination);
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[] {};
        Data removed = q.poll();
        String remKey = removed.destination + "#" + removed.timestamp + "#" + removed.source;
        seen.remove(remKey);
        removeFromDest(removed.destination, removed.timestamp);
        return new int[]{removed.source, removed.destination, removed.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        DestData dd = destMap.get(destination);
        List<Integer> times = dd.times;
        List<Integer> prefix = dd.prefix;
        if (times.isEmpty()) return 0;

        int idxEnd = upperBound(times, endTime) - 1;
        if (idxEnd < 0) return 0;

        int idxStart = lowerBound(times, startTime) - 1;

        int sumEnd = prefix.get(idxEnd);
        int sumStart = idxStart >= 0 ? prefix.get(idxStart) : 0;
        return sumEnd - sumStart;
    }

    private int lowerBound(List<Integer> arr, int key) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr.get(mid) >= key) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(List<Integer> arr, int key) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr.get(mid) > key) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
