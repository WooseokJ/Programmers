import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        // 여벌 가져온 사람
        for(int i: reserve) {
            reserveSet.add(i);
        }
        // 체육복 잃어버린 사람 처리
        for(int p: lost) {
            
            // 여벌 가져온 사람이 잃어버린 경우
            if(reserveSet.contains(p)) {
                reserveSet.remove(p);
            } else { // 잃어버리기만한경우
                lostSet.add(p);
            }
        }
        
        // 잃어버린 사람에게 빌려줄경우
        for(Integer i : reserveSet) {
            // 앞 번호 줄수있는경우
            if(lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if(lostSet.contains(i+1)) { // 뒷번호 에게 줄수있는경우
                lostSet.remove(i+1);
            }
        }
        return n - lostSet.size();
        
        
        
        
        
    }
}