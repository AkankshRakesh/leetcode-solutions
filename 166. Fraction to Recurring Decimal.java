class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        StringBuilder ans = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) ans.append("-");
        ans.append(num / den);
        if(num % den == 0) return ans.toString();

        ans.append(".");
        long remainder = num % den;
        HashMap<Long, Integer> hm = new HashMap<>();
        while(remainder != 0){
            if(hm.containsKey(remainder)){
                ans.insert(hm.get(remainder), "(");
                ans.append(")");
                break;
            }
            hm.put(remainder, ans.length());
            remainder *= 10;
            ans.append(remainder / den);
            remainder %= den;
        }

        return ans.toString();
    }
}