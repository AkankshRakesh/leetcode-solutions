class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++){
            for(int stop : routes[i]){
                if(!adj.containsKey(stop)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    adj.put(stop, temp);
                }
                else adj.get(stop).add(i);
            }
        }
        // for(Map.Entry<Integer, ArrayList<Integer>> ele : adj.entrySet()){
        //     System.out.print(ele.getKey() + " : ");
        //     for(int stop : ele.getValue()) System.out.print(stop + " ");
        //     System.out.println();
        // }

        if(!adj.containsKey(source)) return -1;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        for(int route : adj.get(source)){
            for(int i = 0; i < routes[route].length; i++){
                if(routes[route][i] != source) q.offer(routes[route][i]);

            }
            visited.add(route);
        }

        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                int station = q.poll();
                if(station == target) return ans;

                for(int route : adj.get(station)){
                    if(visited.contains(route)) continue;
                    for(int i = 0; i < routes[route].length; i++){
                        if(routes[route][i] != station) q.offer(routes[route][i]);
                    }
                    visited.add(route);
                }

                size--;
            }
            ans++;
        }

        return -1;
    }
}