class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<List<String>> res = new ArrayList();
        for(String str : strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String s = new String(chArr);
            if(hm.get(s) == null){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str);
                res.add(temp);
                int addedAtIndex = res.size() - 1;
                hm.put(s, addedAtIndex);
            }
            else{
                res.get(hm.get(s)).add(str);
            }
        }
        return res;
    }
}