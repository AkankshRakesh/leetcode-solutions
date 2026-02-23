class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        int left = 0;
        for(int i = k; i < s.length(); i++){
            hs.add(s.substring(left, i));
            // System.out.println(s.substring(left, i));
            left++;
        }

        hs.add(s.substring(left, s.length()));
        if(hs.size() != (int)(Math.pow(2, k))) return false;
        return true;
    }
}