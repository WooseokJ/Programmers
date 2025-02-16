import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		int q = Integer.parseInt(token.nextToken());
		Character[][] grid = new Character[n][n];
		for(int i= 0;i < n; i++) {
			token = new StringTokenizer(br.readLine(), "");
			String str = token.nextToken();
			for(int j= 0;j < n;j++)  {
				grid[i][j] = str.charAt(j);
			}

		}	
		
		for(int i=0;i < q; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(token.nextToken())-1;
			int x = Integer.parseInt(token.nextToken())-1;
			char c = token.nextToken().charAt(0);
			
			bfs(y,x,c,grid, n, k);
		}
		
		print(grid);
			

	}
	public static void print(Character[][] grid) {
		int n = grid.length;
		for(int i=0;i < n; i++){
			for(int j=0;j < n;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	public static void bfs(int y, int x,char c,  Character[][] grid, int n, int k) {
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		grid[y][x] = c;
		
		boolean[][] visited = new boolean[n][n];
		visited[y][x] = true;
		
		Deque<Integer[]> q = new ArrayDeque();
		q.offer(new Integer[]{y,x});
		List<Integer[]> arr = new ArrayList<>();
		arr.add(new Integer[]{y,x});
		
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			for(int i=0;i < 4;i++) {
				int ny = cur[0] + dr[i];
				int nx = cur[1] + dc[i];
				if((nx >= 0 && nx < n) && (ny >=0 && ny < n)) {
					if(!visited[ny][nx] && (c == grid[ny][nx]) ) {
						visited[ny][nx] = true;
						q.offer(new Integer[]{ny, nx});
						arr.add(new Integer[]{ny,nx});
					}
				}
			}	
		}
		
		if(arr.size() >= k) {
			for(Integer[] a: arr) {
				grid[a[0]][a[1]] = '.';
			}

		}
		
	}
}

		
// AD..C
// ...ZZ
// .....
// ....B
// CC.AB


// 5 5 6
// AB..C
// BBAZZ
// ....A
// BBB.B
// CCBAB
// 3 4 A
// 3 1 A
// 3 3 A
// 3 2 B
// 3 2 A
// 1 2 D
