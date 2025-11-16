class Solution {
    public List<Integer> compute(StringBuilder exp){
        List<Integer> res = new ArrayList<>();
        boolean isNum = true;
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) < '0' || exp.charAt(i) > '9'){
                isNum = false;
                List<Integer> left = compute(new StringBuilder(exp.substring(0, i)));
                List<Integer> right = compute(new StringBuilder(exp.substring(i + 1)));
                switch(exp.charAt(i)){
                    case '+':
                        for(int leftRes : left){
                            for(int rightRes : right){
                                res.add(leftRes + rightRes);
                            }
                        }
                        break;
                    case '-':
                        for(int leftRes : left){
                            for(int rightRes : right){
                                res.add(leftRes - rightRes);
                            }
                        }
                        break;
                    case '*':
                        for(int leftRes : left){
                            for(int rightRes : right){
                                res.add(leftRes * rightRes);
                            }
                        }
                        break;
                }
            }
        }

        if(isNum) res.add(Integer.parseInt(exp.toString()));
        return res;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        return compute(new StringBuilder(expression));
    }
}