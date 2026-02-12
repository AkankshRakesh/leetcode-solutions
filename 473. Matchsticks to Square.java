class Solution {
    public boolean dfs(int[] matches,int index, long[] buckets, long sum){
        if(index >= matches.length){
            if(buckets[0] == buckets[1] && buckets[1] == buckets[2] && buckets[2] == buckets[3] && buckets[0] == sum) return true;
            return false;
        }

        if(buckets[0] + matches[index] <= sum){
            buckets[0] += matches[index];
            boolean l0 = dfs(matches, index + 1, buckets, sum);
            buckets[0] -= matches[index];
            if(l0) return true;
        }

        if(buckets[1] + matches[index] <= sum){
            buckets[1] += matches[index];
            boolean l1 = dfs(matches, index + 1, buckets, sum);
            buckets[1] -= matches[index];
            if(l1) return true;
        }

        if(buckets[2] + matches[index] <= sum){
            buckets[2] += matches[index];
            boolean l3 = dfs(matches, index + 1, buckets, sum);
            buckets[2] -= matches[index];
            if(l3) return true;
        }

        if(buckets[3] + matches[index] <= sum){
            buckets[3] += matches[index];
            boolean l4 = dfs(matches, index + 1, buckets, sum);
            buckets[3] -= matches[index];
            if(l4) return true;
        }

        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        for(int i = 0; i < matchsticks.length / 2; i++){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }
        long sum = 0;
        for(int matches : matchsticks) sum += matches;
        if(sum % 4 != 0) return false;
        sum /= 4;

        return dfs(matchsticks, 0, new long[]{0, 0, 0, 0}, sum);
    }
}