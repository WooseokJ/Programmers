import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> arr = new ArrayList<>();
        for(int[] command: commands) {
            int start = command[0];
            int end = command[1];
            int k = command[2];
            List<Integer> temp = new ArrayList<>();
            for(int i = start; i <= end; i++) {
                temp.add(array[i-1]);
            }
            Collections.sort(temp);
            arr.add(temp.get(k-1));
            
        }
        
        
        int[] ans = new int[arr.size()];
        for(int i= 0;i < arr.size();i++)
            ans[i] = arr.get(i);
        return ans;
    }
}