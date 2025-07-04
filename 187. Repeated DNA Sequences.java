class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hs = new HashSet<String>();
        HashSet<String> dup = new HashSet<String>();
        int n = s.length();
        ArrayList<String> arr = new ArrayList<String>();

        for(int i = 0; i < n - 9; i++){
            String str = s.substring(i, i + 10);
            if(hs.contains(str) && !dup.contains(str)){
                arr.add(str);
                dup.add(str);
            }
            else hs.add(str);
        }

        return arr;
    }
}