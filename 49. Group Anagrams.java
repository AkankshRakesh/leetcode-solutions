class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str: strs){
            char tempArr[] = str.toCharArray();
            Arrays.sort(tempArr);
            String sortedStr = new String(tempArr);
            
            if(!hm.containsKey(sortedStr)){
                hm.put(sortedStr, ans.size());
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                ans.add(temp);
            }
            else{
                ans.get(hm.get(sortedStr)).add(str);
            }
        }

        return ans;
    }
}