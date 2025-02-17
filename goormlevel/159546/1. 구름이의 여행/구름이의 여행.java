import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token =new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		
		Map<Integer, List<Integer>> map = new HashMap();
		for(int i=1;i <= n;i++)
			map.put(i, new ArrayList<>());
		
		for(int i=0;i < m; i++) {
			token =new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		Deque<Integer> q = new ArrayDeque();
		q.offer(1);
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[1] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next: map.get(cur)) {
				if(dp[next] == -1) {
					dp[next] = dp[cur] + 1;
					q.offer(next);
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		if(dp[n] <= k && dp[n] >=0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
		
		
	}
}