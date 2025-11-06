class Solution {
    public String addStrings(String num1, String num2) {
        int i= num1.length()-1;
        int j = num2.length()-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0||carry!=0)
        {
            int d1=(i>=0)?num1.charAt(i)-'0':0;
            int d2=(j>=0)?num2.charAt(j)-'0':0;
            int sum = d1+d2+carry;
             carry = sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        return sb.reverse().toString();
        
    }
    
    public boolean check(String s1, String s2, String s3){
        String sum = addStrings(s1, s2);
        if(sum.length() > s3.length()) return false;
        if(sum.equals(s3.substring(0, sum.length()))){
            if(sum.length() == s3.length()) return true;
            return check(s2, sum, s3.substring(sum.length()));
        }
        
        return false;
    }
    public boolean isSumString(String s) {
        // ArrayList<Long> arr = new ArrayList<>();
        // return backtrack(new StringBuilder(s), arr);
        // StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i < s.length(); i++){
            for(int j = 1; i + j < s.length(); j++){
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, i + j);
                String s3 = s.substring(j + i);
            
                if(check(s1, s2, s3)) return true;
            }
        }
        
        return false;
    }
}