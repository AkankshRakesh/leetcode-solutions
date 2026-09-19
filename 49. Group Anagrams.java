class Solution {
    public String getFreq(String str){
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(freq[i] + " ");
        }

        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int index = 0;

        for(String str : strs){
            String freqStr = getFreq(str);
            if(hm.containsKey(freqStr)){
                ans.get(hm.get(freqStr)).add(str);
            }
            else{
                List<String> arr = new ArrayList<>();
                arr.add(str);
                ans.add(arr);
                hm.put(freqStr, index);
                index++;
            }
        }

        return ans;
    }
}