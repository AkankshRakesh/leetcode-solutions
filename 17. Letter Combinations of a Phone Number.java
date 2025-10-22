class Solution {
    public char[] numToLetter(int num){
        if(num == 2) return new char[]{'a', 'b', 'c'};
        else if(num == 3) return new char[]{'d', 'e', 'f'};
        else if(num == 4) return new char[]{'g', 'h', 'i'};
        else if(num == 5) return new char[]{'j', 'k', 'l'};
        else if(num == 6) return new char[]{'m', 'n', 'o'};
        else if(num == 7) return new char[]{'p', 'q', 'r', 's'};
        else if(num == 8) return new char[]{'t', 'u', 'v'};
        else return new char[]{'w', 'x', 'y', 'z'};
    }
    public void backtrack(List<String> ans, StringBuilder curr, String digits, int index){
        if(index >= digits.length()){
            ans.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for(char ch : numToLetter(digit)){
            curr.append(ch);
            backtrack(ans, curr, digits, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), digits, 0);
        
        return ans;
    }
}