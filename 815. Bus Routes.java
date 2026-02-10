class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            int[] route = routes[i];
            for(int stop : route){
                ArrayList<Integer> temp = adj.getOrDefault(stop, new ArrayList<>());
                temp.add(i);
                adj.put(stop, temp);
            }
        }

        if(source == target) return 0;
        if(!adj.containsKey(source) || !adj.containsKey(target)) return -1;

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        for(int route : adj.get(source)){
            visited[route] = true;
            for(int stops : routes[route]){
                q.offer(stops);
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int stop = q.poll();
                if(stop == target) return count + 1;

                for(int route : adj.get(stop)){
                    if(visited[route]) continue;
                    for(int j = 0; j < routes[route].length; j++){
                        int nextStop = routes[route][j];
                        q.offer(nextStop);
                    }
                    visited[route] = true;
                }
            }
            count++;
        }

        return -1;
    }
}