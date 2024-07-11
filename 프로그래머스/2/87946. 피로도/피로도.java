import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        
        
        // 최소피로도, 소모피로도 
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(new ArrayList<>(), n, visited, ans);
        
        int max = 0;
        int init_k = k;
        for(List<Integer> idxList: ans) {
            int val = 0;
            k = init_k;
            for(Integer i: idxList) {
                int minPirodo = dungeons[i][0];
                int consumePirodo = dungeons[i][1];
                if(k >= minPirodo) {
                    k-= consumePirodo;
                    val++;
                } else {
                    break;
                }
            }
            
            max = Math.max(max, val);
        }
        
        return max;
        
    }
    
    
    public static void backtrack(List<Integer> curr, int n, boolean[] visited, List<List<Integer>> ans) {
        if(curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(i);
                backtrack(curr, n, visited, ans);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}