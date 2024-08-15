import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1,o2 ) -> o1[0] - o2[0]);
        
        Queue<Info> pq = new PriorityQueue<>();
        int curTime = 0; // 현재시간
        int curCompleteCnt = 0; // 현재 완료 개수
        int totalTime = 0; // 전체 시간
        int curIdx = 0; // 현재 인덱스
        int totalCnt = jobs.length; // 현재 작업개수
        
        while(curCompleteCnt != totalCnt) {
            
            // 현재 인덱스 < 전체 개수 && jobs 시작시간 <= 현재시간.
            while(curIdx < totalCnt &&  jobs[curIdx][0] <= curTime) {
                int startTime = jobs[curIdx][0]; // 작업 요청 시간
                int processTime = jobs[curIdx][1];// 작업 소요시간.
                pq.offer(new Info(startTime, processTime));    
                curIdx++;
            }
            
            if(!pq.isEmpty()) {
                Info task = pq.poll();
                curTime += task.process;
                totalTime += (curTime - task.start);
                curCompleteCnt++; // 작업완료개수 + 1
            } else {
                curTime =  jobs[curIdx][0];
            }
            
            
        }
        return totalTime / totalCnt;
        
        
    }
    public static class Info implements Comparable<Info>{
        int start, process;
        public Info(int start, int process) {
            this.start = start;
            this.process = process;
        }
        @Override
        public int compareTo(Info o) {
            return this.process - o.process;
        }
        
    }
}