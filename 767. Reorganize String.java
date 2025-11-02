class Solution {
    class Pair{
        char ch;
        int count;
        public Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()) hm.put(ch, hm.getOrDefault(ch, 0) + 1);

        for(Map.Entry<Character, Integer> ele : hm.entrySet()) pq.offer(new Pair(ele.getKey(), ele.getValue()));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() && pq.size() >= 2){
            Pair first = pq.poll();
            Pair second = pq.poll();
            sb.append(first.ch).append(second.ch);
            if(first.count != 1) pq.offer(new Pair(first.ch, first.count - 1));
            if(second.count != 1) pq.offer(new Pair(second.ch, second.count - 1));
        }
        if(pq.size() == 1 && pq.peek().count == 1 && (sb.isEmpty() || sb.charAt(sb.length() - 1) != pq.peek().ch)) sb.append(pq.poll().ch);
        
        System.out.println(sb);
        if(!pq.isEmpty()) return "";
        return sb.toString();
    }
}