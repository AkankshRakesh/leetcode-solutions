class Solution {
    boolean isNull = false;
    public String encode(List<String> strs) {
        if(strs.size() == 0) isNull = true;
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str.length() + "-" + str);
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if(isNull) return ans;
        
        int i = 0;
        while(i < str.length()){
            int len = 0;
            while(str.charAt(i) != '-'){
                len *= 10;
                len += str.charAt(i) - '0';
                i++;
            }
            int end = i + len;
            StringBuilder sb = new StringBuilder();
            if(end < str.length()) ans.add(str.substring(i + 1, end + 1));

            i = end + 1;
        }

        return ans;
    }
}
