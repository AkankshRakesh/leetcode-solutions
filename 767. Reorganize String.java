class Solution {
    class Pair{
        Character ch;
        Integer count;
        public Pair(Character ch, Integer count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        if(s.length() == 1) return s;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(Map.Entry<Character, Integer> ele : hm.entrySet()){
            pq.offer(new Pair(ele.getKey(), ele.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            Pair first = pq.poll();
            Pair second = pq.poll();
            
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == first.ch){
                sb.append(second.ch);
                sb.append(first.ch);
            }
            else{
                sb.append(first.ch);
                sb.append(second.ch);
            }
            if(first.count != 1) pq.offer(new Pair(first.ch, first.count - 1));
            if(second.count != 1) pq.offer(new Pair(second.ch, second.count - 1));
        }
        
        // System.out.println(sb.charAt(sb.length() - 1));
        if(pq.size() == 1){
            if(pq.peek().count > 1 || sb.charAt(sb.length() - 1) == pq.peek().ch) return "";
            else sb.append(pq.peek().ch);
        }
        return sb.toString();
    }
}