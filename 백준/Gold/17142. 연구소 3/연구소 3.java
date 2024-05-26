
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};

    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        Character[][] grid = new Character[n][n];
        List<Point> allVirus = new ArrayList<>();
        int target = 0;
        for(int r = 0; r < n; r++) {
            token = new StringTokenizer(br.readLine(), " ");
            for(int c =0; c < n ; c ++) {
                grid[r][c] = token.nextToken().charAt(0);
                switch (grid[r][c]) {
                    case '0': target++; break;
                    case '2': allVirus.add(new Point(r, c,0)); // 바이러스 위치 저장
                }
            }
        }

        // 전체 바이러스 개수중 m개 뽑은 조합 activeVirus에 저장.
        List<List<Point>> activeVirus = new ArrayList<>();
        combination(new ArrayList<>(), allVirus, 0, m , activeVirus);


        for(List<Point> active: activeVirus) {
            Character[][] copy = copyGrid(grid);
            bfs(active, copy, target);
        }

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void bfs(List<Point> active, Character[][] copy, int target) {
        Deque<Point> q = new ArrayDeque<>();
        for(Point p: active) {
            q.offer(p);
            copy[p.r][p.c] = '1';
        }
        int infacted = 0;
        int time = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curRow = cur.r;
            int curCol = cur.c;
            int curTime = cur.time; // 경과시간
            for(int i =0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isValid(nextRow, nextCol, copy) && copy[nextRow][nextCol] != '1') {
                    if(copy[nextRow][nextCol] == '0') {
                        infacted++;
                        time = curTime + 1;
                    }
                    copy[nextRow][nextCol] = '1';
                    q.add(new Point(nextRow, nextCol, curTime+1));
                }
            }
            if(infacted == target) break;
        }
        if(infacted == target) {
            ans = Math.min(ans, time);
        }

    }

    static Character[][] copyGrid(Character[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Character[][] result = new Character[n][m];
        for(int r = 0; r < n ; r++) {
            result[r] = Arrays.copyOf(grid[r], grid[r].length);
        }
        return result;
    }
    // 순회시 내부에 있는지
    public static boolean isValid(int r, int c, Character[][] copy) {
        int rowLen = copy.length;
        int colLen = copy[0].length;
        return ((0 <= r && r < rowLen) && (0 <= c & c < colLen));
    }

    // 바이러스 개수중 m개만큼 조합
    public static void combination(List<Point> curr, List<Point> allVirus, int start, int k, List<List<Point>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < allVirus.size() ;i++) {
            curr.add(allVirus.get(i));
            combination(curr, allVirus, i+1, k, ans);
            curr.remove(curr.size() - 1);
        }
    }

    // 바이러스 위치 와 시간.
    public static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

}