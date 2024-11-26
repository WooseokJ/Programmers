import java.util.*;
class Solution {
    public int solution(String numbers) {
        int ans = 0;
        
        int n= numbers.length();
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i=1; i <= n; i++ ) {
            backtrack(new ArrayList<>(), n, i, arr);    
        }
        for(List<Integer> a: arr) {
            StringBuilder sb = new StringBuilder();
            for(Integer idx: a) {
                char c = numbers.charAt(idx);
                sb.append(c);
            }
            int num = Integer.parseInt(sb.toString());
            if(set.contains(num)) continue;

            if(isVaild(num)) {
                ans++;
                set.add(num);
            }
            // System.out.println(num +" " +  ans);    
            // System.out.println(a);
        }
            
        
        
        return ans;
    }
    public static boolean isVaild(int n) {
        if(n == 0 || n == 1) return false;
        int cnt = 0;
        for(int i =2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public static void backtrack(List<Integer> curr, int n, int k, List<List<Integer>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i =0; i < n; i++) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(curr, n, k, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}
