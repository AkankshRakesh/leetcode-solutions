class Solution {
    public String maxSumOfSquares(int n, int sum) {
        StringBuilder sb = new StringBuilder();
        while(sum != 0 && n != 0){
            if(sum >= 9){
                sum -= 9;
                sb.append("9");
            }
            else{
                sb.append(sum + "");
                sum = 0;
            }
            n--;
        }

        if(sum != 0) return "";
        while(n != 0){
            sb.append("0");
            n--;
        }
        
        return sb.toString();
    }
}