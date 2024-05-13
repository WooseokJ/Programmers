import java.util.*;

class Solution {
    public int solution(String[][] relations) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int colLen = relations[0].length;
        
        // 속성개수 1개부터 시작해서 1~ n개까지 조합 생성.
        for(int colcnt = 1; colcnt <= colLen; colcnt++) {
            combinations(new ArrayList<>(), 0, colcnt, relations, ans);
        }
        
        return ans.size();
        
    }
   public static void combinations(List<Integer> curr, int start, int k, String[][] relations, List<List<Integer>> ans)     {
        int rowLen = relations.length;
        int colLen = relations[0].length;
       
        // 조합이 만들어지면.
        if(curr.size() == k) {
            // 최소성, 유일성 깨지면 종료
            if(!unique(curr, relations) || !minimalcheck(curr, ans)) {
                return ;
            }
            // 최소성, 유일성 만족하므로 추가.
            ans.add(new ArrayList<>(curr));
            return ;
        }   
        // 조합 로직.
        for(int i = start; i < colLen; i ++) {
            curr.add(i);
            combinations(curr, i+1, k, relations, ans);
            curr.remove(curr.size()-1);
        }
       
       
   }
    // 유일성 검사
    public static boolean unique(List<Integer> curr, String[][] relations) {
        List<String> uniqueValArr = new ArrayList<>();
        int rowLen = relations.length;
        // 튜플 개수만큼 검사.
        for(int row = 0; row < rowLen; row++) {
            StringBuilder sb = new StringBuilder();
            for(Integer col: curr) {
                sb.append(relations[row][col]);
            }
            String element = sb.toString();
            if(!uniqueValArr.contains(element)) {
                uniqueValArr.add(element);
            }else { 
                // 유일성 깨짐.
                return false;
            }
        }
        return true;
    }
    
    // 최소성 검사
    public static boolean minimalcheck(List<Integer> curr, List<List<Integer>> ans){
        
        for(List<Integer> key: ans) {
            // key의 모든원소가 curr에 포함되어있지않으면 최소성 깨짐.
            if(curr.containsAll(key)) { 
                //최소성 깨짐
                return false;
            }
        }
        return true;
    }
    

}