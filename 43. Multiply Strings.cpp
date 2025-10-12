class Solution {
    public String mult(String num1, int n2) {
        if (n2 == 0) return "0";

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int currRes = n1 * n2 + carry;
            sb.append(currRes % 10);
            carry = currRes / 10;
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? a.charAt(i--) - '0' : 0;
            int y = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String ans = "0";
        int zeros = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            String prod = mult(num1, n2);

            for (int z = 0; z < zeros; z++) {
                prod += "0";
            }

            ans = addStrings(ans, prod);
            zeros++;
        }

        return ans;
    }
}
