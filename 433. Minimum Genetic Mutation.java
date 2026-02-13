class Solution {
    public void addVariations(String gene, HashMap<String, Integer> hm, boolean[] visited, Queue<String> q){
        for(int i = 0; i < gene.length(); i++){
            StringBuilder sb = new StringBuilder(gene);
            sb.setCharAt(i, 'A');
            String g1 = sb.toString();

            sb.setCharAt(i, 'C');
            String g2 = sb.toString();

            sb.setCharAt(i, 'G');
            String g3 = sb.toString();

            sb.setCharAt(i, 'T');
            String g4 = sb.toString();

            if(hm.containsKey(g1) && !visited[hm.get(g1)]){
                visited[hm.get(g1)] = true;
                q.offer(g1);
            }

            if(hm.containsKey(g2) && !visited[hm.get(g2)]){
                visited[hm.get(g2)] = true;
                q.offer(g2);
            }

            if(hm.containsKey(g3) && !visited[hm.get(g3)]){
                visited[hm.get(g3)] = true;
                q.offer(g3);
            }

            if(hm.containsKey(g4) && !visited[hm.get(g4)]){
                visited[hm.get(g4)] = true;
                q.offer(g4);
            }
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, Integer> hm = new HashMap<>();
        boolean[] visited = new boolean[bank.length];
        int index = 0;
        for(String gene : bank) hm.put(gene, index++);
        if(!hm.containsKey(endGene)) return -1;

        Queue<String> q = new LinkedList<>();
        addVariations(startGene, hm, visited, q);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int i = 0; i < size; i++){
                String gene = q.poll();
                if(gene.equals(endGene)) return ans;
                addVariations(gene, hm, visited, q);
            }
        }

        return -1;
    }
}