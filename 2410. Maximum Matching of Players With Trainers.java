class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(trainers);
        Arrays.sort(players);

        int count = 0;
        int index = m - 1;
        for(int i = n - 1; i >= 0; i--){
            if(index < 0) break;
            if(players[i] <= trainers[index]){
                count++;
                index--;
            }
        }

        return count;
    }
}