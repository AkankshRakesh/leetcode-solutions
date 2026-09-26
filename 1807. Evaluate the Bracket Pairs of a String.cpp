class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        for(List<String> ele : knowledge){
            hm.put(ele.get(0), ele.get(1));
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();

        while(index < s.length()){
            if(s.charAt(index) == '('){
                index++; // skip (

                StringBuilder curr = new StringBuilder();
                while(s.charAt(index) != ')') curr.append(s.charAt(index++));
                if(hm.containsKey(curr.toString())) sb.append(hm.get(curr.toString()));
                else sb.append("?");

                index++; // skip )
            }
            else sb.append(s.charAt(index++));
        }
        return sb.toString();
    }
}