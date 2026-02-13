class Solution {
    public int balancedForTwo(String s, char ch1, char ch2){
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int ans = 0;
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
            else ans = Math.max(ans, i - hm.get(count));
        }

        return ans;
    }
    public int longestBalanced(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("0-0", -1);
        int cA = 0, cB = 0, cC = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') cA++;
            else if(s.charAt(i) == 'b') cB++;
            else cC++;

            String temp = (cB - cA) + "-" + (cC - cA);
            if(!hm.containsKey(temp)) hm.put(temp, i);
            else ans = Math.max(ans, i - hm.get(temp));
        }

        ans = Math.max(ans, balancedForTwo(s, 'a', 'b'));
        ans = Math.max(ans, balancedForTwo(s, 'c', 'b'));
        ans = Math.max(ans, balancedForTwo(s, 'c', 'a'));

        int count = 1;
        int res = 1;
        char ch = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ch){
                count = 1;
                ch = s.charAt(i);
            }

            res = Math.max(res, count);
            count++;
        }

        return Math.max(ans, res);
    }
}