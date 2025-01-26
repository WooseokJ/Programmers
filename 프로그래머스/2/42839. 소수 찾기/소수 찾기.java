import java.util.*;
class Solution {
    public int solution(String numbers) {
        int ans = 0;
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 1; i<= numbers.length(); i++) {
            backtrack(new ArrayList<>(), numbers.length(), i, arr);
        }
        Set<Integer> set = new HashSet<>();
        for(List<Integer> a: arr) {
            // System.out.println(a);
            StringBuilder sb = new StringBuilder();
            for(Integer b: a) {
                char c = numbers.charAt(b);
                sb.append(c);
            }
            int n = Integer.parseInt(sb.toString());
            if(!set.contains(n)) {
                set.add(n);
            }
        }
        for(Integer n: set) {
            if(n == 0 || n == 1) continue;
            int cnt =0;
            for(int i=1; i<= n; i++) {
                if(n % i == 0) {
                    cnt++;
                }
            }
            if(cnt == 2) {
                ans++;
            }
        }
        

        
        
        return ans;
    }
    public static void backtrack(List<Integer> curr, int n, int k, List<List<Integer>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i < n; i++) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(curr, n, k, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}