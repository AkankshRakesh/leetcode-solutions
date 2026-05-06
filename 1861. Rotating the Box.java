class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length, m = boxGrid[0].length;
        char[][] ans = new char[m][n];
        
        for(int i = 0; i < n; i++){
            int last = -1;
            for(int j = m - 1; j >= 0; j--){
                if(boxGrid[i][j] == '.'){
                    ans[j][n - i - 1] = '.';
                    if(last == -1) last = j;
                }
                else if(boxGrid[i][j] == '*'){
                    ans[j][n - i - 1] = '*';
                    last = -1;
                }
                else if(last != -1){
                    ans[last][n - i - 1] = '#';
                    ans[j][n - i - 1] = '.';
                    last--;
                }
                else{
                    ans[j][n - i - 1] = '#';
                }
            }
        }
        
        return ans;
    }
}