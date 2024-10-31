import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int ans = 0;
        List<List<Integer>> arr = new ArrayList<>();
        int n = numbers.length;
        for(int i =0; i < n; i++)
            backtrack(new ArrayList<>(), 0, n, i, arr);
        

        
        for(List<Integer> a: arr) {
            int[] copy = Arrays.copyOf(numbers, n);
            
            for(Integer b: a) {
                copy[b] *= -1;
            }
            int sum = 0;
            for(int t: copy)
                sum+=t;
            if(sum == target) ans++;
        }
            
        
        
        
        return ans;
    }
    public static void backtrack(List<Integer> cur, int start, int n ,int k, List<List<Integer>> ans) {
        if(cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < n; i++) {
            cur.add(i);
            backtrack(cur, i+1, n,k,ans);
            cur.remove(cur.size()-1);
                
        }
        
        
            
        
            
        
    }
}