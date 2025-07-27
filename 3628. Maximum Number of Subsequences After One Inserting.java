class Solution {
    public long countLCT(String s){
        long l = 0, lc = 0, lct = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'L') l++;
            else if(ch == 'C') lc += l;
            else if(ch == 'T') lct += lc;
        }

        return lct;
    }
    public long numOfSubsequences(String s) {
        int n = s.length();
        long c = countLCT(s);
        long gain = 0;

        long[] sufT = new long[n + 1];
        for(int i = n - 1; i >= 0; i--){
                sufT[i] = (s.charAt(i) == 'T' ? 1 : 0) + sufT[i + 1];
        }

        long[] preL = new long[n + 1];
        for(int i = 0; i < n; i++){
            preL[i + 1] = (s.charAt(i) == 'L' ? 1 : 0) + preL[i];
        }

        for(int i = 0; i <= n; i++){
            long temp = preL[i] * sufT[i];
            gain = Math.max(gain, temp);
        }

        int l = 0;
        int lc = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                l++;
            } else if (ch == 'C') {
                lc += l;
            }
            gain = Math.max(gain, lc);
        }

        long[] sufC = new long[n + 1];
        for(int i = n - 1; i >= 0; i--){
            sufC[i] = sufC[i + 1] + (s.charAt(i) == 'C' ? 1 : 0);
        }

        long t = 0;
        long tempGain = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == 'T') t++;
            else if(s.charAt(i) == 'C') tempGain += t;
        }
        gain = Math.max(gain, tempGain);


        return c + gain;
    }
}