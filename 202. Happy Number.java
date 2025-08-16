class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;

        HashSet<Integer> hs = new HashSet<>();
        while(!hs.contains(n)){
            if(n == 1) return true;

            hs.add(n);
            int next = 0;
            while(n != 0){
                next += ((n % 10) * (n % 10));
                n /= 10;
            }

            n = next;
        }

        return false;
    }
}