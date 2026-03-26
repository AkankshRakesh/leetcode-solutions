class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int n){
            if(parent[n] != n) return parent[n] = find(parent[n]);
            return n;
        }

        public void union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return;

            if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else if(rank[p1] > rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emails = new HashMap<>();
        DSU dsu = new DSU(accounts.size());
        for(int i = 0; i < accounts.size(); i++){
            List<String> accs = accounts.get(i);
            for(int j = 1; j < accs.size(); j++){
                String email = accs.get(j);
                if(emails.containsKey(email)) dsu.union(i, emails.get(email));
                else emails.put(email, i);
            }
        }

        HashMap<Integer, List<String>> res = new HashMap<>();
        HashMap<Integer, HashSet<String>> userEmails = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> accs = accounts.get(i);
            int parent = dsu.find(i);
            if(!res.containsKey(parent)) res.put(parent, new ArrayList<>());
            if(!userEmails.containsKey(parent)) userEmails.put(parent, new HashSet<>());

            for(int j = 1; j < accs.size(); j++){
                if(emails.get(accs.get(j)) == i && !userEmails.get(parent).contains(accs.get(j))){
                    userEmails.get(parent).add(accs.get(j));
                    res.get(parent).add(accs.get(j));
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> ele : res.entrySet()){
            int index = ele.getKey();
            List<String> arr = ele.getValue();
            Collections.sort(arr);
            List<String> nameArr = new ArrayList<>();
            nameArr.add(accounts.get(index).get(0));
            for(String str : arr) nameArr.add(str);

            ans.add(nameArr);
        }

        return ans;
    }
}