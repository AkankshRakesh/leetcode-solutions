class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        int n = code.length;
        String match = "electronics";
        while(match != "."){
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(businessLine[i].equals(match) && isActive[i]){
                    String coupon = code[i];
                    boolean isValid = true;
                    for(int j = 0; j < coupon.length(); j++){
                        if(!((coupon.charAt(j) >= 'a' && coupon.charAt(j) <= 'z') || (coupon.charAt(j) >= 'A' && coupon.charAt(j) <= 'Z') || (coupon.charAt(j) >= '0' && coupon.charAt(j) <= '9') || coupon.charAt(j) == '_' )){
                            isValid = false;
                            break;
                        }
                    }
                    if(!isValid || coupon.length() == 0) continue;
                    temp.add(coupon);
                }
            }
            Collections.sort(temp);
            for(String str : temp) ans.add(str);
            if(match.equals("electronics")) match = "grocery";
            else if(match.equals("grocery")) match = "pharmacy";
            else if(match.equals("pharmacy")) match = "restaurant";
            else match = ".";
        }

        return ans;
    }
}