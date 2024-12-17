import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {       
        boolean[] visited = new boolean[words.length];    
        return bfs(begin,visited, target, words );
    }
    public static int bfs(String begin, boolean[] visited, String target, String[] words) {
        
        Deque<Info> q = new ArrayDeque<>();
        q.offer(new Info(0, begin));
        while(!q.isEmpty()) {
            Info cur = q.poll();
            if(cur.word.equals(target)) 
                return cur.step;    
            for(int i= 0; i< words.length; i++) {
                if(!cur.word.equals(words[i])) {
                    int diff = 0;
                    for(int j = 0; j < words[i].length(); j++) {
                        int front = words[i].charAt(j);
                        int back = cur.word.charAt(j);
                        if(front != back)
                            diff++;
                    }
                    
                    if(diff==1 && !visited[i]) { // 차이 1, 방문안한 word
                        visited[i] = true;
                        q.offer(new Info(cur.step+1, words[i]));
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