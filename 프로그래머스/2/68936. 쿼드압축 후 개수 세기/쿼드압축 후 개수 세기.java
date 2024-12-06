
class Solution {
    public int[] solution(int[][] arr) {
        int[] ans = {0,0};
        backtrack(arr, 0,0, arr.length, ans);
        
        return ans;
    }
    public static void backtrack(int[][] arr, int x, int y , int size, int[] ans) {
        if(zip(arr, x,y,size, arr[x][y])) {
            if(arr[x][y] == 1) ans[1]++;
            else ans[0]++;
            return;
        }
        int add = size / 2;
        backtrack(arr,x,y,add, ans); 
        backtrack(arr,x,y + add, add , ans);
        backtrack(arr, x+add, y , add, ans);
        backtrack(arr, x+add, y+add, add, ans);
    }
    public static boolean zip(int[][] arr, int x, int y, int size,int val) {
        for(int i= x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}