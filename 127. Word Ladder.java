class Solution {
    public void addVariations(String word, HashMap<String, Integer> hm, boolean[] visited, Queue<String> q){
        for(int i = 0; i < word.length(); i++){
            StringBuilder sb = new StringBuilder(word);
            for(int j = 0; j < 27; j++){
                char ch = (char)('a' + j);
                sb.setCharAt(i, ch);
                String temp = sb.toString();
                if(hm.containsKey(temp) && !visited[hm.get(temp)]){
                    visited[hm.get(temp)] = true;
                    q.offer(temp);
                }
            }
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        int index = 0;
        for(String word : wordList) hm.put(word, index++);

        if(!hm.containsKey(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];

        int ans = 1;
        addVariations(beginWord, hm, visited, q);
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return ans;
                addVariations(word, hm, visited, q);
            }
        }

        return 0;
    }
}