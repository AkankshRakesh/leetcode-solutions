class Solution {
    public boolean backtrack(String bottom, int index, HashMap<String, ArrayList<Character>> allowedHm, StringBuilder nextRow, HashMap<String, Boolean> memo){
        if(index == bottom.length() - 1){
            if(nextRow.length() == 1) return true;

            String next = nextRow.toString();
            if (memo.containsKey(next)) return memo.get(next);

            boolean res = backtrack(next, 0, allowedHm, new StringBuilder(), memo);
            memo.put(next, res);
            return res;
        }

        char first = bottom.charAt(index);
        char second = bottom.charAt(index + 1);
        String base = first + "" + second;
        if(!allowedHm.containsKey(base)) return false;

        for(Character ch : allowedHm.get(base)){
            nextRow.append(ch);
            if(backtrack(bottom, index + 1, allowedHm, nextRow, memo)) return true;
            nextRow.deleteCharAt(nextRow.length() - 1);
        }

        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, ArrayList<Character>> allowedHm = new HashMap<>();
        HashMap<String, Boolean> memo = new HashMap<>();
        for(String str : allowed){
            String base = str.charAt(0) + "" + str.charAt(1);     
            // System.out.println(str.substring(0, 2) + " " + base);
            if(allowedHm.containsKey(base)) allowedHm.get(base).add(str.charAt(2));
            else{
                ArrayList<Character> arr = new ArrayList<>();
                arr.add(str.charAt(2));
                allowedHm.put(base, arr);
            }
        }
        return backtrack(bottom, 0, allowedHm, new StringBuilder(), memo);
    }
}   