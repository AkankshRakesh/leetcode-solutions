class Solution {
    public int smallestRepunitDivByK(int k) {
        int count = 1;
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int curr = 1;
        HashSet<Integer> hs = new HashSet<>();
        while(curr != 0){
            if(curr % k == 0) break;
            int next = curr * 10 + 1;
            curr = next % k;
            count++;
            if(hs.contains(curr)) return -1;
            hs.add(curr);
        }

        return count;
    }
}