import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		Map<Integer, List<Integer>> map = new HashMap();
		for(int i=1;i <= n;i++)
			map.put(i, new ArrayList<>());
		// 양방향 연결 
		for(int i=0;i < m;i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
		Deque<Integer> q = new ArrayDeque();
		q.offer(1);
		int[] visited = new int[n+1];
		Arrays.fill(visited, -100);
		visited[1] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			List<Integer> arr = map.get(cur);
			for(int next: arr) {
				// 방문한적 없어
				if(visited[next] == -100) {  
					visited[next] = visited[cur] + 1;
					q.offer(next);
				}
			}
		}
		if(1 <= visited[n] && visited[n] <= k) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		

		
	}
}