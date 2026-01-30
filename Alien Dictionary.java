class Solution {
    public String findOrder(String[] words) {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> inDeg = new HashMap<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                inDeg.put(word.charAt(i), 0);
            }
        }
        int totalChars = inDeg.size();
        
        for(int i = 1; i < words.length; i++){
            String past = words[i - 1];
            String curr = words[i];
            int l1 = 0, l2 = 0;
            while(l1 < past.length() && l2 < curr.length()){
                if(past.charAt(l1) != curr.charAt(l2)){
                    if(adj.containsKey(past.charAt(l1))){
                        if(!adj.get(past.charAt(l1)).contains(curr.charAt(l2))) inDeg.put(curr.charAt(l2), inDeg.get(curr.charAt(l2)) + 1);
                        adj.get(past.charAt(l1)).add(curr.charAt(l2));
                    }
                    else{
                        HashSet<Character> hs = new HashSet<>();
                        hs.add(curr.charAt(l2));
                        adj.put(past.charAt(l1), hs);
                        inDeg.put(curr.charAt(l2), inDeg.get(curr.charAt(l2)) + 1);
                    }
                    break;
                }
                l1++;
                l2++;
            }
            if(l1 < past.length() && l2 == curr.length()) return "";
        }
        
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> ele : inDeg.entrySet()){
            if(ele.getValue() == 0) q.offer(ele.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);
            
            if(!adj.containsKey(ch)) continue;
            for(Character neig : adj.get(ch)){
                inDeg.put(neig, inDeg.get(neig) - 1);
                if(inDeg.get(neig) == 0){
                    q.offer(neig);
                }
            }
        }
        
        if(sb.length() != inDeg.size()) return "";
        return sb.toString();
    }
}