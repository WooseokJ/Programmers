import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int ans = 0;
        
        int n = words.length;
        boolean[] visited = new boolean[n];
        Deque<Info> q = new ArrayDeque<>();
        q.offer(new Info(0, begin));
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            if(cur.word.equals(target)) return cur.step;
            
            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                // 현재 단어 아니면 diff계산.
                if(!word.equals(cur.word)) {
                    int diff = 0;
                    for(int j =0 ; j < word.length(); j++) {
                        int front = word.charAt(j);
                        int back = cur.word.charAt(j);
                        if(front != back)
                            diff++;
                    }
                    
                    if(diff == 1 && !visited[i]) {
                        visited[i] = true;
                        q.offer(new Info(cur.step+1, word));
                    }
                    
                }
                
            }
        }
            
        
            
  
        
        
        return 0;
    }
    
    public static class Info {
        int step;
        String word;
        Info(int step, String word) {
            this.step = step;
            this.word = word;
        }
    }
}