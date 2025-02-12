import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		int[][] arr = new int[n][n];
		Map<Integer, Integer> map =new HashMap<>();
		for(int i=1;i <= 30; i++)
			map.put(i,0);
		
		for(int i=0;i < n;i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for(int j= 0;j < n; j++) {
				int a = Integer.parseInt(token.nextToken());
				arr[i][j] = a;
				if(!map.containsKey(a)) {
					map.put(a, 0);
				}
			}
		}
		
		boolean[][] visited = new boolean[n][n];
		int ans = 1;
		for(int r =0; r< n; r++) {
			for(int c = 0; c < n; c++) {
				if(!visited[r][c]) {
					int cnt = bfs(r, c, visited, arr, n);
					
					
					
					
					if(cnt >= k) {
						int m = map.get(arr[r][c]) + 1;
						map.put(arr[r][c], m);
					}
				}
			}
		}
		for(int i=1;i <= 30; i++) {
			if(map.get(i) != null ) {
				if(map.get(i) >= map.get(ans)) {
					ans = i;
				}
			}
		}
		
		// for(Integer key: map.keySet()) {
		// 	if(map.get(key) > map.get(ans)) {
		// 		ans = key;
		// 	} 
		// 	if(map.get(key) == map.get(ans)) {
		// 		ans = Math.max(ans, key);
		// 	} 
		// }
		// System.out.println(map);
		
		System.out.println(ans);
		
		
		// 단지: 인접한 관계에 속한 건물개수 k이상 
		// 1:4, 2: 2
		
	}
	public static int bfs(int r, int c, boolean[][] visited, int[][] arr, int n) {
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		visited[r][c] = true;
		Deque<Integer[]> q = new ArrayDeque();
		q.offer(new Integer[]{r,c});
		int cnt =1;
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			for(int i=0;i < 4;i ++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if((nr >= 0 && nr < n) && (nc>=0 && nc < n)) {
					if(!visited[nr][nc] && (arr[nr][nc] == arr[r][c])) {
						visited[nr][nc] = true;
						q.offer(new Integer[]{nr,nc});
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
}

