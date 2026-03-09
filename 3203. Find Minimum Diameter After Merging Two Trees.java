class Solution {
    public int getFarthest(int n, HashMap<Integer, ArrayList<Integer>> adj, int vertex){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(vertex);
        int dist = 0;
        int farthestNode = 0;
        visited[vertex] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                farthestNode = node;
                if(!adj.containsKey(node)) continue;
                for(int neig : adj.get(node)){
                    if(!visited[neig]){
                        q.offer(neig);
                        visited[neig] = true;
                    }
                }
            }
        }

        return farthestNode;
    }
    public int findDiameter(int n ,HashMap<Integer, ArrayList<Integer>> adj){
        int first = getFarthest(n, adj, 0);
        int second = getFarthest(n, adj, first);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(first);
        int dist = -1;
        visited[first] = true;
        while(!q.isEmpty()){
            dist++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                if(node == second) return dist;
                if(!adj.containsKey(node)) continue;
                for(int neig : adj.get(node)){
                    if(!visited[neig]){
                        q.offer(neig);
                        visited[neig] = true;
                    }
                }
            }
        }

        return 0;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer, ArrayList<Integer>> adj1 = new HashMap<>();
        for(int[] edge : edges1){
            ArrayList<Integer> arr1 = adj1.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<Integer> arr2 = adj1.getOrDefault(edge[1], new ArrayList<>());
            arr1.add(edge[1]);
            arr2.add(edge[0]);
            adj1.put(edge[0], arr1);
            adj1.put(edge[1], arr2);
        }

        HashMap<Integer, ArrayList<Integer>> adj2 = new HashMap<>();
        for(int[] edge : edges2){
            ArrayList<Integer> arr1 = adj2.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<Integer> arr2 = adj2.getOrDefault(edge[1], new ArrayList<>());
            arr1.add(edge[1]);
            arr2.add(edge[0]);
            adj2.put(edge[0], arr1);
            adj2.put(edge[1], arr2);
        }

        int c1 = findDiameter(edges1.length, adj1);
        int c2 = findDiameter(edges2.length, adj2);
        // System.out.println(c2);
        return (int)Math.max(c1, Math.max(c2, Math.ceil(c1/2.0) + Math.ceil(c2/2.0) + 1));
    }
}