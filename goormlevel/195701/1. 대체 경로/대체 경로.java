import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int s = Integer.parseInt(token.nextToken());
		int e = Integer.parseInt(token.nextToken());
		List<List<Integer>> arr = new ArrayList<>();
		for(int i=0;i <= n;i++)
			arr.add(new ArrayList<>());
			
		for(int i=0;i <m ;i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		// i 는 i에서 공사함.  
		for(int i = 1; i <= n; i++) {
			if(i == s || i == e) {
				System.out.println("-1");
				continue;
			}
			boolean[] visited = new boolean[n+1];
			visited[i] = true; // 공사 함. 처리 
			int result = calc(s,e,visited,arr);
			System.out.println(result);
		}
		
		
	}
	public static int calc(int s, int e, boolean[] visited, List<List<Integer>> arr) {
		
		Queue<Info> pq = new PriorityQueue();
		pq.offer(new Info(s, 1));
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(cur.node == e)	 {
				return cur.val;
			}
			for(int next: arr.get(cur.node)) {
				if(!visited[next]) {
					visited[next] = true;
					pq.offer(new Info(next, cur.val + 1));
				}
			}
		}
		return -1;
	}
	public static class Info implements Comparable<Info>  {
		int node, val;
		Info(int n, int v){
			node=  n;
			val = v;
		}
		@Override
		public int compareTo(Info o) {
			return this.val - o.val;
		}
}
}