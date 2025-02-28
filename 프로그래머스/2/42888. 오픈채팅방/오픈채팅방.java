import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        
        Map<String, String> map = new HashMap<>();
        Deque<String[]> q = new ArrayDeque<>();
        for(String str: record) {
            StringTokenizer token = new StringTokenizer(str, " ");
            String c = token.nextToken();
            String id = token.nextToken();
            String name;
            if(!c.equals("Leave")) {
                name = token.nextToken();
                map.put(id, name);
            }
            if(!c.equals("Change")) {
                q.offer(new String[]{c, id});    
            }
            
            // System.out.println(map);
        }
        String[] ans = new String[q.size()];
        int idx = 0;
        while(!q.isEmpty()) {
            String[] cur = q.poll();
            String c = cur[0];
            String id =cur[1];
            String name = map.get(id);
            if(c.equals("Enter")) {
                ans[idx] = name + "님이 들어왔습니다.";
            } else {
                
                ans[idx] = name + "님이 나갔습니다.";
            }
            idx++;
        }
        
        
        return ans;
    }
}

// 변경기록 record.
// 나가면 새닉네임으로 다시들어감.
// prodo, prodo, ryan
// 