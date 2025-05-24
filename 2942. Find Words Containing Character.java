class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] arr = new int[26];
        int indToCheck = x - 'a';
        int ind = 0;
        for(String word : words){
            for(int i = 0; i < word.length(); i++){ 
                arr[word.charAt(i) - 'a']++;
            }
            if(arr[indToCheck] != 0) ans.add(ind);
            ind++;
            arr = new int[26];
        }
        return ans;
    }
}