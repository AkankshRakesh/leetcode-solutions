class Solution {
    public boolean addDig(Character ch1, Character ch2, StringBuilder sb, boolean carry){
        if(ch1 == '1' && ch2 == '1'){
            if(carry) sb.append("1");
            else sb.append("0");
            carry = true;
        }
        else if(ch1 == '1' || ch2 == '1'){
            if(carry) sb.append("0");
            else sb.append("1");
        }
        else{
            if(carry) sb.append("1");
            else sb.append("0");
            carry = false;
        }
        return carry;
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false;
        while(i >= 0 && j >= 0){
            carry = addDig(a.charAt(i), b.charAt(j), sb, carry);
            i--;
            j--;
        }

        while(i >= 0){
            carry = addDig(a.charAt(i), '0', sb, carry);
            i--;
        }
        while(j >= 0){
            carry = addDig('0', b.charAt(j), sb, carry);
            j--;
        }
        if(carry) sb.append("1");

        return sb.reverse().toString();
    }
}