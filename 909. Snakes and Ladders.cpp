class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        int n = board.length;

        int ele = 1;
        boolean leftToRight = true;

        for(int i = n - 1; i >= 0; i--){
            if(leftToRight){
                for(int j = 0; j < n; j++){
                    hm.put(ele, new int[]{i, j});
                    ele++;
                }
            }
            else{
                for(int j = n - 1; j >= 0; j--){
                    hm.put(ele, new int[]{i, j});
                    ele++;
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cell = q.poll();
                if(cell == n * n) return ans;

                for(int j = 1; j <= 6; j++){
                    int next = cell + j;
                    if(next <= n * n){
                        int x = hm.get(next)[0];
                        int y = hm.get(next)[1];
                        if(visited[x][y]) continue;
                        
                        System.out.println(x + " " + y + " " + next);
                        if(board[x][y] != -1) q.offer(board[x][y]);
                        else q.offer(next);

                        visited[x][y] = true;
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}