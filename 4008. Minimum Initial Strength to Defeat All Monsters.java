class Solution {
    public boolean canDefeat(long strength, int[] monsters, long[] diff){
        long bonus = 0;

        for(int i = 0; i < monsters.length; i++){
            bonus += diff[i];
    
            if(strength + bonus < monsters[i]) return false;

            strength = Math.max(strength - monsters[i], 0);
        }

        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long ans = Integer.MAX_VALUE;

        long[] diff = new long[monsters.length + 1];
        for(int[] boost : boosts){
            diff[boost[0]] += boost[2];
            diff[boost[1] + 1] -= boost[2];
        }

        long left = 0, right = 0;
        for(int monster : monsters) right += monster;
        
        while(left <= right){
            long mid = left + (right - left) / 2;

            if(canDefeat(mid, monsters, diff)){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return ans;
    }
}