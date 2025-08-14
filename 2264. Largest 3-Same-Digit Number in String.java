class Solution {
    public String largestGoodInteger(String num) {
        int left = 0;
        int ans = -1;
        for(int right = 2; right < num.length(); right++, left++){
            if(num.charAt(left) == num.charAt(right) && num.charAt(left) == num.charAt(left + 1)){
                ans = Math.max(ans, num.charAt(left) - '0');
            }
        }

        switch(ans){
            case 0:
                return "000";
            case 1:
                return "111";
            case 2:
                return "222";
            case 3:
                return "333";
            case 4:
                return "444";
            case 5:
                return "555";
            case 6:
                return "666";
            case 7:
                return "777";
            case 8:
                return "888";
            case 9:
                return "999";
        }

        return "";
    }
}