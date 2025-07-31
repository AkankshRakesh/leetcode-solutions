class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastSeen = new int[26];
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            lastSeen[ch - 'a'] = i;
        }

        HashSet<Character> hs = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int lastInd = 0;
        for(int i = 0; i < n; i++){
            hs.add(s.charAt(i));
            boolean res = true;
            for(char ch : hs){
                if(lastSeen[ch - 'a'] > i){
                    res = false;
                    break;
                }
            }

            if(res){
                arr.add(i - lastInd + 1);
                lastInd = i + 1;
            }
        }

        // arr.add(n - lastInd);
        return arr;
    }
}