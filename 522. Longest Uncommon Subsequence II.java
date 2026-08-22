class Solution {
    public void makeSubseq(String s, int index, HashSet<String> hs, StringBuilder sb){
        if(index >= s.length()){
            hs.add(sb.toString());
            return;
        }

        makeSubseq(s, index + 1, hs, sb);
        sb.append(s.charAt(index));
        makeSubseq(s, index + 1, hs, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public int findLUSlength(String[] strs) {
        HashMap<Integer, HashSet<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            HashSet<String> hs = new HashSet<>();
            makeSubseq(strs[i], 0, hs, new StringBuilder());
            hm.put(i, hs);
        }

        int ans = -1;
        for(int i = 0; i < strs.length; i++){
            HashSet<String> curr = hm.get(i);
            for(String str : curr){
                if(str == "") continue;
                boolean found = false;
                for(int j = 0; j < strs.length; j++){
                    if(i == j) continue;
                    HashSet<String> hs = hm.get(j);
                    if(hs.contains(str)){
                        // System.out.println(str);
                        found = true;
                        break;
                    }
                }
                if(!found) ans = Math.max(ans, str.length());
            }
        }

        return ans;
    }
}