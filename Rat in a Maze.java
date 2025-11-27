class Solution {
    public void backtrack(ArrayList<String> ans, int[][] maze, int i, int j, StringBuilder curr, boolean[][] visited){
        if(i >= maze.length || j >= maze[0].length || i < 0 || j < 0) return;
        if(i == maze.length - 1 && j == maze[0].length - 1){
            ans.add(new String(curr.toString()));
            return;
        }
        
        if(maze[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        
        // System.out.println(i + " " + j);
        curr.append('U');
        backtrack(ans, maze, i - 1, j, curr, visited);
        curr.deleteCharAt(curr.length() - 1);
        
        curr.append('D');
        backtrack(ans, maze, i + 1, j, curr, visited);
        curr.deleteCharAt(curr.length() - 1);
        
        curr.append('L');
        backtrack(ans, maze, i, j - 1, curr, visited);
        curr.deleteCharAt(curr.length() - 1);
        
        curr.append('R');
        backtrack(ans, maze, i, j + 1, curr, visited);
        curr.deleteCharAt(curr.length() - 1);
        
        visited[i][j] = false;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        backtrack(ans, maze, 0, 0, new StringBuilder(), visited);
        
        Collections.sort(ans);
        return ans;
    }
}