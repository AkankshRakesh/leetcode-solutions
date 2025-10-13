class Solution {
    public int[] getArr(String word){
        int[] ans = new int[26];
        for(int i = 0; i < word.length(); i++){
            ans[word.charAt(i) - 'a']++;
        }

        return ans;
    }

    public boolean isAnagram(int[] w1, int[] w2){
        for(int i = 0; i < 26; i++){
            if(w1[i] != w2[i]) return false;
        }

        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        Stack<int[]> st = new Stack<>();
        Stack<String> ansSt = new Stack<>();
        st.push(getArr(words[0]));
        ansSt.push(words[0]);

        for(int i = 1; i < words.length; i++){
            String word = words[i];
            int[] currWord = getArr(word);
            int[] pastWord = st.peek();
            if(!isAnagram(currWord, pastWord)){
                st.push(currWord);
                ansSt.push(word);
            }
        }

        List<String> ans = new ArrayList<>();
        while(!ansSt.isEmpty()) ans.add(ansSt.pop());

        Collections.reverse(ans);

        return ans;
    }
}