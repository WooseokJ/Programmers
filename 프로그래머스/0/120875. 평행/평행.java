import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        
//         Arrays.sort(dots, (o1,o2) -> {
//            return o1[0]-o2[0]; 
//         });
        
//         double x1 = dots[0][0]; double y1 = dots[0][1];
//         double x2 = dots[1][0]; double y2 = dots[1][1];
        
//         double l1 = (y2-y1) / (x2-x1);
        
//         double x3 = dots[2][0]; double y3 = dots[2][1];
//         double x4 = dots[3][0]; double y4 = dots[3][1];
        
//         double l2 = (y4-y3) / (x4-x3);        
//         if(l1 == l2) 
//             return 1; 
//         return 0;
        
        List<List<Integer>> arr = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 4, 4, arr);
        for(List<Integer> a: arr) {
            System.out.println(a);
             Integer idx1 = a.get(0);
            Integer idx2 = a.get(1);
            Integer idx3 = a.get(2);
            Integer idx4 = a.get(3);
            
            int x1 = dots[idx1][0]; int y1 = dots[idx1][1];
            int x2 = dots[idx2][0]; int y2 = dots[idx2][1];
            int x3 = dots[idx3][0]; int y3 = dots[idx3][1];
            int x4 = dots[idx4][0]; int y4 = dots[idx4][1];
            double l1 = (double) (y2-y1) / (x2-x1);
            double l2 = (double) (y4-y3) / (x4-x3);
            // System.out.println(l1 + " " + l2);
            if(l1 == l2)
                return 1;
        }
        return 0;
           
        
        
        
        

    }
    public static void backtrack(List<Integer> curr, int start, int n, int k, List<List<Integer>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < n ;i++) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(curr, i+1, n, k, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}