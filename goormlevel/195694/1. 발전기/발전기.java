import java.io.*;
import java.util.*;
class Main {
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0;i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");	
			for(int j = 0;j < n; j++) 
				arr[i][j] = Integer.parseInt(token.nextToken());
		}
		
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i < n; i++) {
			for(int j=0;j < n;j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					ans += dfs(i,j,visited, arr, n);
				}
			}
		}
		System.out.println(ans);
	}
	public static int dfs(int r, int c, boolean[][] visited, int[][] arr, int n) {
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		visited[r][c] = true;
		Deque<Integer[]> q = new ArrayDeque();
		q.offer(new Integer[]{r,c});

		while(!q.isEmpty()) {
			Integer[] cur = q.poll();

			for(int i=0; i < 4;i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];

				if((nr >= 0  && nr < n) && (nc >= 0 && nc < n)) {
					if(!visited[nr][nc] && arr[nr][nc] == 1) {
						visited[nr][nc] = true;
						q.offer(new Integer[]{nr,nc});
					}
				}
			}
		}
		return 1;
		
		
		
	}
}