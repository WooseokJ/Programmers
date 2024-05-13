import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int ans = 0;
        int init_k = k;
        // arr 에는 열의 개수만큼의 index에 대한 순열 값들이 있다. 
        List<List<Integer>> arr = permutation(dungeons);

        for(List<Integer> indexArr : arr) {
            int cnt = 0;
            k = init_k;  // k 초기화.
            // 새로운 인덱스 배열로 시도
            for(Integer i: indexArr) {
                int minRequiredPirodo = dungeons[i][0];
                int consumePirodo = dungeons[i][1];
                if(k >= minRequiredPirodo) { // 최소 필수 피로도 이상이면.
                    k-= consumePirodo;
                    cnt++;
                }     
            }
            // 배열 시도 이전의 값중 가장큰값(ans) vs 새로운 인덱스 배열시도(cnt)
            ans = Math.max(ans, cnt);
        }
        

        return ans;
    
    }
    // 순열 
    public List<List<Integer>> permutation(int[][] dungeons) {
        // dungeons의 최소필요피로도 개수만큼의 index값 갖는 nums 생성.
        int n = dungeons.length;
        int[] nums = new int[n]; 
        for(int i = 0; i < n; i++) {
            nums[i] = i;
        }
        // 순열 템플릿
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            
            return ;
        }
        
        for(int num: nums) {
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, nums, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    
}