class Solution {
    ArrayList<String> ans = new ArrayList<>();
    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

    public void dfs(String dest){
        while(adj.containsKey(dest) && !adj.get(dest).isEmpty()){
            dfs(adj.get(dest).poll());
        }
        ans.add(0, dest);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> arr : tickets){

            if(adj.containsKey(arr.get(0))){
                adj.get(arr.get(0)).offer(arr.get(1));
            }
            else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(arr.get(1));
                adj.put(arr.get(0), pq);
            }
        }

        dfs("JFK");

        return ans;

    }
}