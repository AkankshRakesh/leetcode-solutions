class Solution {
    class Pair{
        Integer level;
        String node;
        public Pair(String node, Integer level){
            this.level = level;
            this.node = node;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++) hm.put(wordList.get(i), 0);

        Queue<Pair> q = new LinkedList<>();
        if(!hm.containsKey(endWord)) return 0;
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair top = q.poll();
            // System.out.println(top.node);
            hm.put(top.node, top.level);
            
            String node = top.node;
            if(node.equals(endWord)) break;
            StringBuilder sb = new StringBuilder(node);


            for(int i = 0; i < node.length(); i++){
                for(int j = 0; j < 26; j++){
                    sb.setCharAt(i, (char)('a' + j));
                    if(hm.containsKey(sb.toString())){
                        if(hm.get(sb.toString()) == 0){
                            q.offer(new Pair(sb.toString(), top.level + 1));
                        }
                    }
                    sb.setCharAt(i, node.charAt(i));
                }

            }  
        }


        return hm.get(endWord);
    }
}