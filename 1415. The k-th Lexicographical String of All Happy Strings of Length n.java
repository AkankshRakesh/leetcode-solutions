class Solution {
    public void buildStrs(int n, String[] happyStrs, StringBuilder sb, int[] index){
        if(sb.length() == n){
            happyStrs[index[0]] = new String(sb.toString());
            index[0]++;
            return;
        }

        if(sb.charAt(sb.length() - 1) != 'b'){
            sb.append('b');
            buildStrs(n, happyStrs, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(sb.charAt(sb.length() - 1) != 'a'){
            sb.append('a');
            buildStrs(n, happyStrs, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(sb.charAt(sb.length() - 1) != 'c'){
            sb.append('c');
            buildStrs(n, happyStrs, sb, index);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String getHappyString(int n, int k) {
        int totalStrs = 3;
        for(int i = 1; i < n; i++) totalStrs *= 2;
        if(k > totalStrs) return "";
        String[] happyStrs = new String[totalStrs];

        int[] index = new int[]{0};
        buildStrs(n, happyStrs, new StringBuilder("a"), index);
        buildStrs(n, happyStrs, new StringBuilder("b"), index);
        buildStrs(n, happyStrs, new StringBuilder("c"), index);

        Arrays.sort(happyStrs);
        return happyStrs[k - 1];
    }
}