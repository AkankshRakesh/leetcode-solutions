public class 692. Top K Frequent Words {
    
}
class Solution {
    class Pair{
        String word;
        int freq;
        public Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.freq != b.freq ? Integer.compare(b.freq, a.freq) : (a.word).compareTo(b.word));
        for(Map.Entry<String, Integer> ele : hm.entrySet()){
            pq.offer(new Pair(ele.getKey(), ele.getValue()));
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty() && k != 0){
            k--;
            ans.add(pq.poll().word);
        }

        return ans;
    }
}