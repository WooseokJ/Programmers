import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited);
        
        
    }
    public static int bfs(String begin, String target, String[] words, boolean[] visited) {
        Deque<Info> q = new ArrayDeque<>();
        q.offer(new Info(0, begin));
        while(!q.isEmpty()) {
            Info cur = q.poll();
            if(cur.word.equals(target)) {
                
                return cur.step;
            }
            for(int i =0; i < words.length; i++) {
                String word = words[i];
                if(!word.equals(cur.word)) {
                    int diff = 0;
                    for(int j = 0; j < word.length(); j++) {
                        int front = words[i].charAt(j);
                        int back = cur.word.charAt(j);
                        if(front != back)
                            diff++;
                    }
                    
                    // 한글짜식 차이나고 !방문한적없으면 
                    if(diff == 1 && !visited[i]) {
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