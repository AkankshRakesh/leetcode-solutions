class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word : wordList) hm.put(word, -1);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        hm.put(beginWord, 1);

        while(!q.isEmpty()){
            String word = q.poll();
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(i == 0 ? "" : word.substring(0, i));
                for(int j = 0; j < 26; j++){
                    StringBuilder temp = new StringBuilder(sb);
                    char ch = (char)(j + 'a');
                    temp.append(ch);
                    temp.append(word.substring(i + 1, word.length()));
                    if(hm.containsKey(temp.toString()) && hm.get(temp.toString()) == -1){
                        hm.put(temp.toString(), hm.get(word) + 1);
                        q.offer(temp.toString());
                        // System.out.println(word + "-" + hm.get(word));
                    }
                }
            }
        }

        if(!hm.containsKey(endWord) || hm.get(endWord) == -1) return 0;
        return hm.get(endWord);
    }
}