class Solution {
    public void merge(List<Integer> res, List<Integer> x, List<Integer> y, char opt){
        if(opt == '+'){
            for(int ele1 : x){
                for(int ele2 : y){
                    res.add(ele1 + ele2);
                }
            }
        }
        else if(opt == '-'){
            for(int ele1 : x){
                for(int ele2 : y){
                    res.add(ele1 - ele2);
                }
            }
        }
        else{
            for(int ele1 : x){
                for(int ele2 : y){
                    res.add(ele1 * ele2);
                }
            }
        }
    }
    public List<Integer> divide(StringBuilder exp){
        List<Integer> res = new ArrayList<>();
        boolean optFound = false;
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*'){
                optFound = true;
                StringBuilder part1 = new StringBuilder();
                StringBuilder part2 = new StringBuilder();
                for(int j = 0; j < i; j++) part1.append(exp.charAt(j));
                for(int j = i + 1; j < exp.length(); j++) part2.append(exp.charAt(j));
                List<Integer> x = divide(part1);
                List<Integer> y = divide(part2);
                merge(res, x, y, exp.charAt(i));
            }
        }
        if(!optFound){
            res.add(Integer.parseInt(exp.toString()));
        }

        return res;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return divide(new StringBuilder(expression));
    }
}