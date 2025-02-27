import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        StringBuilder sb = new StringBuilder();
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        for(String c: cards1)
            q1.offer(c);
        for(String c: cards2)
            q2.offer(c);
        
        int cnt = 0;
        for(String str: goal) {
            String s1 = "";
            String s2 = "";
            if(!q1.isEmpty())
                s1 = q1.poll();
            if(!q2.isEmpty())
                s2 = q2.poll();
            

            if(!s1.equals("") && s1.equals(str)) {
                q2.offerFirst(s2);
                cnt++;
            }
            if(!s2.equals("") && s2.equals(str)) {
                q1.offerFirst(s1);
                cnt++;
            }
        }
        // System.out.println(cnt);
        if(cnt == goal.length) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        
        // 순서대로 1장씩
        // 사용시 사라져
        // 
        
        
        return sb.toString();
    }
}