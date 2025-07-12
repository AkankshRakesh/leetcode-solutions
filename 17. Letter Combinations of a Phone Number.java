class Solution {
    public void backtrack(String digits, int index, int n, ArrayList<String> arr, String curr, HashMap<Character, ArrayList<String>> hm){
        if(index == n){
            if(curr != "") arr.add(curr);
            return;
        }

        ArrayList<String> list = hm.get(digits.charAt(index));
        for(int i = 0; i < list.size(); i++){
            backtrack(digits, index + 1, n, arr, curr + list.get(i), hm);
        }
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> arr = new ArrayList<String>();
        HashMap<Character, ArrayList<String>> hm = new HashMap<Character, ArrayList<String>>();
        for(int i = 2; i < 10; i++){
            ArrayList<String> temp = new ArrayList<String>();
            switch(i){
                case 2:
                    temp.add("a");
                    temp.add("b");
                    temp.add("c");
                    hm.put('2', temp);
                    break;
                case 3:
                    temp.add("d");
                    temp.add("e");
                    temp.add("f");
                    hm.put('3', temp);
                    break;
                case 4:
                    temp.add("g");
                    temp.add("h");
                    temp.add("i");
                    hm.put('4', temp);
                    break;
                case 5:
                    temp.add("j");
                    temp.add("k");
                    temp.add("l");
                    hm.put('5', temp);
                    break;
                case 6:
                    temp.add("m");
                    temp.add("n");
                    temp.add("o");
                    hm.put('6', temp);
                    break;
                case 7:
                    temp.add("p");
                    temp.add("q");
                    temp.add("r");
                    temp.add("s");
                    hm.put('7', temp);
                    break;
                case 8:
                    temp.add("t");
                    temp.add("u");
                    temp.add("v");
                    hm.put('8', temp);
                    break;
                case 9:
                    temp.add("w");
                    temp.add("x");
                    temp.add("y");
                    temp.add("z");
                    hm.put('9', temp);
                    break;
            }
        }
        backtrack(digits, 0, digits.length(), arr, "", hm);
        return arr;
    }
}