class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        Arrays.sort(lights);
        int bestLight = lights[lights.length - 1];

        int ans = 0;
        for(int time : arrivalTime){
            int r = time % period;
            if(r >= bestLight){
                ans = Math.max(ans, period - r);
            }
        }

        return ans;
    }
}