import java.util.*;
class Solution {
  public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1 ,j2) -> j1[0] - j2[0] );
        Queue<Info> pq = new PriorityQueue<>();
        int curTime = 0;
        int completeJob = 0;
        int totalResponseTime = 0;
        int idx = 0;
        int totalJobsCnt = jobs.length;
        while(completeJob < totalJobsCnt) {

            while (idx < totalJobsCnt && jobs[idx][0] <= curTime) {
                int startTime = jobs[idx][0];
                int processTime = jobs[idx][1];
                pq.offer(new Info(startTime, processTime));
                idx++;
            }

            if(!pq.isEmpty()) { // 현재시간기준 작업할수있는 요소들기준으로 현재시간업데이트
                Info job = pq.poll();
                curTime += job.processTime;
                totalResponseTime += (curTime - job.startTime);
                completeJob++;

            } else {
                // 현재시간기준 작업가능 task 없으므로 현재시간을 다음 시간으로 이동.
                curTime = jobs[idx][0];
            }
        }

        return totalResponseTime / totalJobsCnt;



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