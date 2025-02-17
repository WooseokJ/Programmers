import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=1; i<=n;i++)
			map.put(i, new ArrayList<>());
		
		for(int i=0;i < m;i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
		Deque<Integer> q = new ArrayDeque();
		q.offer(1);
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		int ans = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next: map.get(cur)) {
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
		
		
		
		
	}
}