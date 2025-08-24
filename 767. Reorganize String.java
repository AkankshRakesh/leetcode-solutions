class Solution {
    class Pair{
        Integer count;
        Character letter;
        public Pair(Character letter, Integer count){
            this.count = count;
            this.letter = letter;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);    
        }
        for(int i = 0; i < n; i++){
            if(hm.containsKey(s.charAt(i))){
                pq.offer(new Pair(s.charAt(i), hm.get(s.charAt(i))));
                hm.remove(s.charAt(i));
            }
        }
        
        int index = 0;
        while(!pq.isEmpty() && pq.size() >= 2){
            Pair first = pq.poll();
            Pair second = pq.poll();

            if(index == 0 || sb.charAt(index - 1) != first.letter){
                sb.append(first.letter);
                sb.append(second.letter);
            }
            else{
                sb.append(second.letter);
                sb.append(first.letter);
            }

            if(first.count != 1) pq.offer(new Pair(first.letter, first.count - 1));
            if(second.count != 1) pq.offer(new Pair(second.letter, second.count - 1));
        }
        if(pq.size() == 1){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != pq.peek().letter){
                if(pq.peek().count > 1) return "";
                sb.append(pq.peek().letter);
            }
            else return "";
        }
        return sb.toString();
    }
}