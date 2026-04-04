class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char[][] grid = new char[rows][cols];
        int index = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = encodedText.charAt(index + j);
                // System.out.print(grid[i][j]);
            }
            // System.out.println();
            index += (cols);
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder spaces = new StringBuilder();
        int i = 0, j = 0;
        while(i < rows && j < cols){
            // System.out.println(i + " - " + j);
            if(grid[i][j] == ' ') spaces.append(grid[i][j]);
            else{
                ans.append(spaces.toString());
                spaces = new StringBuilder();
                ans.append(grid[i][j]);
            }
            i++;
            j++;
            if(i >= rows){
                j -= i;
                j++;
                i = 0;
            }
        }

        return ans.toString();
    }
}