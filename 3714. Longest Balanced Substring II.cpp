class Solution {
    public int balancedForTwo(String s, char ch1, char ch2){
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch1) count++;
            else if(s.charAt(i) == ch2) count--;
            else{
                hm = new HashMap<>();
                hm.put(0, i);
                count = 0;
                continue;
            }

            if(!hm.containsKey(count)) hm.put(count, i);
            else res = Math.max(res, i - hm.get(count));
        }

        return res;
    }
    public int single(String s){
        int ans = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(left)){
                ans = Math.max(ans, i - left);
                left = i;
            }
        }
        ans = Math.max(ans, s.length() - left);

        return ans;
    }
    public int longestBalanced(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("0-0", -1);
        int ans = 0;

        // StringBuilder sb = new StringBuilder("0-0-0");
        int[] counts = new int[]{0, 0, 0};

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') counts[0]++;
            else if(s.charAt(i) == 'b') counts[1]++;
            else counts[2]++;

            String temp = (counts[1] - counts[0]) + "-" + (counts[2] - counts[0]);
            if(!hm.containsKey(temp)) hm.put(temp, i);
            else ans = Math.max(ans, i - hm.get(temp));
        }
        
        ans = Math.max(ans, balancedForTwo(s, 'a', 'b'));
        ans = Math.max(ans, balancedForTwo(s, 'b', 'c'));
        ans = Math.max(ans, balancedForTwo(s, 'c', 'a'));
        ans = Math.max(ans, single(s));
        return ans;
    }
}