class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str: strs){
            Integer[] arr = new Integer[26];
            for(char ch : str.toCharArray()){
                if(arr[ch - 'a'] == null) arr[ch - 'a'] = 0;
                arr[ch - 'a']++;
                System.out.println(ch);
                System.out.println(arr[ch - 'a']);

            }
            StringBuilder sortedSb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(arr[i] != null){
                    sortedSb.append(i + 'a');
                    sortedSb.append(arr[i] + '0');
                }
            }
            String sortedStr = sortedSb.toString();
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