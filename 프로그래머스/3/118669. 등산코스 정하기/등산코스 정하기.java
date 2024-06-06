
import java.util.*;
import java.util.stream.*;

class Solution {
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 무방향 그래프 만들기.
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int[] path: paths) {
            int curNode = path[0];
            int nextNode = path[1];
            int weight = path[2];
            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(curNode).add(new Info(nextNode, weight));
            graph.get(nextNode).add(new Info(curNode, weight));
        }

        // weight 리스트
        int INF = Integer.MAX_VALUE;
        int[] visited = new int[n+1]; // [max, max,max...]
        Arrays.fill(visited, INF);

        // 우선순위큐에 출발 gate 넣기 .
        Queue<Info> pq = new PriorityQueue<>();
        for(int gate: gates) {
            pq.offer(new Info(gate, 0));
            visited[gate] = 0;
        }

        // 다익스트라 시작.
        outer: while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(visited[cur.node] < cur.weight) continue outer;
            // 산봉우리들 리스트 순회하면서 현재 노드가 산봉우리이면 무시
            for(int summit: summits) 
                if(summit == cur.node) continue outer;

            if(graph.containsKey(cur.node)) {
                List<Info> arr = graph.get(cur.node);
                for(Info next: arr) {
//                     // 현재와 이전꺼 비교.
                    int nextIntensity = Math.max(cur.weight, next.weight);
                    if(visited[next.node] > nextIntensity) {
                        visited[next.node] = nextIntensity;
                        pq.offer(new Info(next.node, nextIntensity));
                    }
                }
            }
        }


        int[] ans = {0,INF};
        // 정렬: 상봉우리 번호 가장낮은거 선택위해 편의상 정렬.
        Integer[] temp = chageArr(summits);
        Arrays.sort(temp, Collections.reverseOrder());
        for(int summit: temp) {
            int minNode = ans[0];
            int minWeight = ans[1];
            if(minWeight >= visited[summit]) { // visited에있는게 더 가중치(intensity)가 낮아. 그러면 갱신.
                ans[0] = summit;
                ans[1] = visited[summit];
            }
        }
        return ans;

    }
    public static Integer[] chageArr(int[] summits) {
        int n = summits.length;
        Integer[] temp = new Integer[n];
        for(int i =0; i < n; i++) {
            temp[i] = summits[i];
        }
        return temp;
    }

    public static class Info implements Comparable<Info> {
        int node, weight;

        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }


}