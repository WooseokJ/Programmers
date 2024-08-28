class Solution {
    static int[][] key;
    static int[][] lock;
    static int n;
    static int m;
    
    public boolean solution(int[][] k, int[][] l) {
        key = k;
        lock = l;
        n = lock.length;
        m = key.length;
        
        for(int row = m; row > -n ; row-- ) {
            for(int col = m ; col > -n ; col--) {
                if(matchKey(col, row)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    public static boolean matchKey(int col, int row) {
        for(int rotation = 0; rotation < 4; rotation++) {
            boolean match = true;
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    int keyPoint = 0;
                    int keyCol = c + col;
                    int keyRow = r + row;
                    if((0 <= keyCol && keyCol < m) && (0 <= keyRow && keyRow < m)) {
                        keyPoint = getKeyPoint(key,keyCol, keyRow, rotation);
                    }
                    if ((lock[r][c] == 1 && keyPoint == 1) || (lock[r][c] == 0 && keyPoint == 0)) {
                        match = false;
                        break;
                    }
                }
            }
            if(match) {return true;}
        }
        return false;
    }
    public static int getKeyPoint(int[][] key, int c, int r, int rotation) {
        int m = key.length;
        switch (rotation) {
            case 0: return key[r][c]; 
            case 1: return key[c][m-1-r];
            case 2: return key[m-1-r][m-1-c]; 
            case 3: return key[m-1-c][r]; 
        }
        return -1;
    }
}