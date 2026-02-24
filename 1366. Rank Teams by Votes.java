class Solution {
    public String rankTeams(String[] votes) {
        int[][] freq = new int[26][votes[0].length()];
        for(int i = 0; i < votes[0].length(); i++){
            for(String vote : votes){
                char ch = vote.charAt(i);
                freq[ch - 'A'][i]++;
            }
        }

        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i < votes[0].length(); i++) arr.add(votes[0].charAt(i));

        Collections.sort(arr, (a, b) -> {
            for(int i = 0; i < votes[0].length(); i++){
                if(freq[a - 'A'][i] != freq[b - 'A'][i]) return freq[b - 'A'][i] - freq[a - 'A'][i];
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char ch : arr) sb.append(ch);
        return sb.toString();
    }
}