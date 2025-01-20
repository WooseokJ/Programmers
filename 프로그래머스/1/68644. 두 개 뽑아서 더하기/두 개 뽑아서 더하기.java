import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        List<List<Integer>> arr = new ArrayList<>();
        backtrack(new ArrayList<>(), numbers.length, 2 , arr);
        // for(List<Integer> a: arr)
        //     System.out.println(a);
        
        List<Integer> temp = new ArrayList<>();
        for(List<Integer> a: arr) {
            int idx1 = a.get(0);
            int idx2 = a.get(1);
            int sum = numbers[idx1] + numbers[idx2];
            if(!temp.contains(sum))
                temp.add(sum);
        }
        Collections.sort(temp);

        
        int[] ans = new int[temp.size()];
        for(int i= 0; i < temp.size(); i++)
            ans[i] = temp.get(i);
        return ans;
    }
    
    public static void backtrack(List<Integer> curr, int n, int k, List<List<Integer>> ans) {
        if(curr.size()==k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i= 0;i < n ;i++) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(curr, n, k, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}