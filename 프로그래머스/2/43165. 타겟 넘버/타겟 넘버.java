import java.util.*;
class Solution {
    static List<List<Integer>> arr = new ArrayList<>();
    public int solution(int[] numbers, int target) {
        
        int n = numbers.length;
        
    // 0,1,2,3 -> ++++ ~ ---- n 개중 1개 
        

        for(int i =0; i < numbers.length; i++) {
            backtrack(new ArrayList<>(), 0, numbers.length,i,arr);    
        }
        int ans =0;
        // System.out.println(arr);
        for(List<Integer> idxArr : arr) {
            List<Integer> temp = new ArrayList<>();
            
            for(int i =0;i < numbers.length; i++)
                temp.add(numbers[i]);
            
            for(Integer idx: idxArr) {
                temp.set(idx, -1 * numbers[idx]);   
            }
            
            // 
            int sum = 0;
            for(int i =0; i < temp.size(); i++) {
                sum+= temp.get(i);
            }
            
            if(sum == target) {
                
                
                ans++;
            }
        }
        
        
        return ans;
        

    }
    public static void backtrack(List<Integer> curr, int idx, int n , int k, List<List<Integer>> ans ) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));    
            return;
        }
        for(int i = idx; i < n; i++) {
            curr.add(i);
            backtrack(curr, i+1, n, k, ans );
            curr.remove(curr.size()-1);
        }
        
    }
    
    
        
 
}