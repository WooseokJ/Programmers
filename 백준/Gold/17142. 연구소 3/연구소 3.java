
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int ans =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token= new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m= Integer.parseInt(token.nextToken());

        int target = 0;
        List<int[]> allvirus = new ArrayList<>();

        Character[][] grid = new Character[n][n];
        for(int r =0; r< n; r++) {
            token = new StringTokenizer(br.readLine(), " ");
            for(int c =0;c < n; c++) {
                grid[r][c] = token.nextToken().charAt(0);
                if(grid[r][c] == '0') target++;
                else if(grid[r][c] == '2') allvirus.add(new int[]{r,c,0});
            }
        }

        // 전체 바이러스 개수중 m개 뽑은 조합 activeVirust에 저장
        List<List<int[]>> activeVirus = new ArrayList<>();
        backtrack(new ArrayList<>(), allvirus, 0, m, activeVirus);


        for(List<int[]> active: activeVirus) {
            // 2차원 배열 복사
            Character[][] copy = new Character[n][n];
            for(int r =0; r< n; r++)
                copy[r] = Arrays.copyOf(grid[r], grid[r].length);

            bfs(active, copy, target);

        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    // 바이러스 개수중 m개만큼 조합
    public static void backtrack(List<int[]> curr, List<int[]> allvirust, int start, int k, List<List<int[]>> ans) {
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < allvirust.size(); i++) {
            curr.add(allvirust.get(i));
            backtrack(curr, allvirust, i+1, k, ans);
            curr.remove(curr.size()-1);
        }
    }
    public static void bfs(List<int[]> active, Character[][] copy, int target) {
        Deque<int[]> q=  new ArrayDeque<>();
        for(int[] p: active) {
            int x = p[0];
            int y = p[1];
            q.offer(p);
            copy[x][y] = '1';
        }
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        int infacted = 0;
        int time = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0;i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if((0 <= nr && nr < copy.length) && (0 <= nc && nc < copy[0].length) &&
                    (copy[nr][nc] != '1')) {

                    if(copy[nr][nc] == '0' ) {
                        infacted++;
                        time = cur[2]+1;
                    }
                    copy[nr][nc] = '1';
                    q.offer(new int[]{nr,nc,cur[2]+1});
                }


            }
            if(infacted == target) break;

        }

        if(infacted == target)
            ans = Math.min(ans, time);

    }

}
