class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] r = new char[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                r[i][j] = box[m - 1 - j][i];
            }
        }

        for(int col = 0; col < m; col++){
            int c = n - 1;
            for(int row = n - 1; row >= 0; row--){
                if(r[row][col] == '*'){
                    c = row - 1;
                } else if(r[row][col] == '#'){
                    r[row][col] = '.';
                    r[c][col] = '#';
                    c--;
                }
            }
        }

       return r;
    }
}
