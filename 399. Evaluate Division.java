class Solution {
    class Pair{
        String vertex;
        double weight;
        public Pair(String vertex, double weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            ArrayList<Pair> original = adj.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            ArrayList<Pair> reverse = adj.getOrDefault(equations.get(i).get(1), new ArrayList<>());
        
            original.add(new Pair(equations.get(i).get(1), values[i]));
            reverse.add(new Pair(equations.get(i).get(0), 1.0/values[i]));
            adj.put(equations.get(i).get(0), original);
            adj.put(equations.get(i).get(1), reverse);
        }


        double ans[] = new double[queries.size()];
        int index = 0;
        for(List<String> query : queries){
            HashMap<String, Double> visited = new HashMap<>();

            Queue<Pair> q = new LinkedList<>();
            if(!adj.containsKey(query.get(0))){
                ans[index++] = -1;
                continue;
            }
            visited.put(query.get(0), 1.0);
            q.offer(new Pair(query.get(0), 1.0));
            while(!q.isEmpty()){
                Pair top = q.poll();
                // System.out.println(top.vertex + "-" + top.weight);
                if(!adj.containsKey(top.vertex)) continue;
                
                for(Pair neig : adj.get(top.vertex)){
                    // System.out.println(neig.vertex + "-" + neig.weight);
                    if(!visited.containsKey(neig.vertex)){
                        q.offer(new Pair(neig.vertex, neig.weight * top.weight));
                        visited.put(neig.vertex, top.weight * neig.weight);
                    }
                    // else if(visited.get(neig.vertex) != top.weight * neig.weight) visited.put(neig.vertex, -1.0);
                }

                // System.out.println("----");
            }
            ans[index++] = visited.containsKey(query.get(1)) ? visited.get(query.get(1)) : -1;
        }

        return ans;
    }
}