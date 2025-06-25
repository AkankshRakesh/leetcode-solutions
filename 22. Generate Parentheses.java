class Solution {
    public boolean check(String s){
        int n = s.length();
        int value = 0;

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == ')') value++;
            else value--;

            if(value < 0) return false;
        }
        return true;
    }
    public void exploration(List<String> res, String s, int leftPara, int rightPara){
        if(leftPara == 0 && rightPara == 0){
            if(check(s)){
                res.add(s);
            }
            return;
        }
        else if(leftPara == 0){
            exploration(res, s + ")", leftPara, rightPara - 1);
        }
        else if(rightPara == 0){
            exploration(res, s + "(", leftPara - 1, rightPara);
        }
        else{
            exploration(res, s + "(", leftPara - 1, rightPara);
            exploration(res, s + ")", leftPara, rightPara - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> arr = new ArrayList<String>();

        exploration(arr, "(", n - 1, n);
        return arr;
    }
}