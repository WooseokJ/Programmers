import java.util.*;
class Solution {
  public int solution(int[][] jobs) {
        // 작업요청 빠른시점순 정렬. (오름차순)
        Arrays.sort(jobs, (j1 ,j2) -> j1[0] - j2[0] );
      
        Queue<Info> pq = new PriorityQueue<>();
        int curTime = 0; // 현재시간
        int curCompleteCnt = 0; // 현재 완료작업 개수
        int totalResponseTime = 0; // 전체 걸린시간.
        int idx = 0; // 현재 인덱스
        int totalJobCnt = jobs.length; // 전체 작업 개수 
        // 현재완료 작업개수, 전체작업개수 다르면
        while(curCompleteCnt != totalJobCnt) {
     
            
            // 현재 시간기준 작업가능한것들 우선순위큐에 넣기
            // 현재 인덱스 < 전체 작업인덱스 + 현재시간이 > 현재작업시작시간보다 클떄
            while (idx < totalJobCnt && jobs[idx][0] <= curTime) {
                int curStartTime = jobs[idx][0];
                int curProcessTime = jobs[idx][1];
                pq.offer(new Info(curStartTime, curProcessTime));
                idx++;
            }
            
            // 우선순위큐 이용해 소요시간 가장적은작업 선택.
            if(!pq.isEmpty()) { 
                // 현재시간기준 작업할수있는 요소들기준으로 현재시간업데이트
                Info job = pq.poll();
                curTime += job.processTime; // 현재시간 + 작업시간.
                totalResponseTime += (curTime - job.startTime); // 전체 작업시간 = 현재시간 - 작업처음시작시간.
                curCompleteCnt++; // 작업완료 개수 +1

            } else {
                // 현재시간기준 작업가능 task 없으므로 현재시간을 다음 시간으로 이동.
                // 현재시간 업데이트
                curTime = jobs[idx][0];
            }
        }

        return totalResponseTime / totalJobCnt;



    }


    public static class Info implements Comparable<Info> {
        int startTime, processTime;
        public Info(int s, int p) {
            startTime = s;
            processTime = p;
        }
        @Override
        public int compareTo(Info o) {
            return this.processTime - o.processTime; // 최소힙.
        }
    }
}