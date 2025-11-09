class Solution {
    public boolean backtrack(long a, long b, long c, long d, int[] matchsticks, int index, long target, HashMap<String, Boolean> hm){
        if(index >= matchsticks.length){
            if(a == b && b == c && c == d) return true;
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(a)).append("-").append(Long.toString(b)).append("-").append(Long.toString(c)).append("-").append(Long.toString(d)).append("-").append(Integer.toString(index));
        if(hm.containsKey(sb.toString())) return hm.get(sb.toString());

        // System.out.println(sb.toString());
        int curr = matchsticks[index];
        boolean res = false;
        for(int i = 0; i < 4; i++){
            if(i == 0 && curr + a <= target){ res |= backtrack(a + curr, b, c, d, matchsticks, index + 1, target, hm);}
            else if(i == 1 && curr + b <= target){ res |= backtrack(a, b + curr, c, d, matchsticks, index + 1, target, hm);}
            else if(i == 2 && curr + c <= target) {res |= backtrack(a, b, c + curr, d, matchsticks, index + 1, target, hm);}
            else if(i == 3 && curr + d <= target) { res |= backtrack(a, b, c, d + curr, matchsticks, index + 1, target, hm);}
        }

        hm.put(sb.toString(), res);
        return res;
    }
    public boolean makesquare(int[] ms) {
        Arrays.sort(ms);
        for(int i = 0; i < ms.length / 2; i++){
            int temp = ms[ms.length - i - 1];
            ms[ms.length - i - 1] = ms[i];
            ms[i] = temp;
            // System.out.println(ms[i] + "-" + ms[ms.length - i - 1]);
        }
        long target = 0;
        for(int stick : ms) target += stick;
        
        if(target % 4 != 0) return false;
        HashMap<String, Boolean> hm = new HashMap<>();
        return backtrack(0, 0, 0, 0, ms, 0, target / 4, hm);
    }
}