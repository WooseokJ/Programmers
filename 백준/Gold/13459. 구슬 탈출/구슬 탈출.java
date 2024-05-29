
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
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.out.println(extracted());
    }

    private static int extracted() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        Character[][] grid = new Character[n][m];

        Point red = null;
        Point blue = null;
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                grid[r][c] = line.charAt(c);
                switch (grid[r][c]) {
                    case 'R':
                        red = new Point(r, c);
                        break;
                    case 'B':
                        blue = new Point(r, c);
                        break;
                }
            }
        }

        Deque<Entry> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(new Entry(red, blue, 0));
        visited.add(red.r + " " + red.c + " " + blue.r + " " + blue.c);

        while (!q.isEmpty()) {
            Entry cur = q.poll();
            if (cur.distance >= 10) continue;

            for (int i = 0; i < 4; i++) {
                Point nextRed = move(cur.red, i, grid, n, m);
                Point nextBlue = move(cur.blue, i, grid, n, m);

                if (grid[nextBlue.r][nextBlue.c] == 'O') continue;

                if (grid[nextRed.r][nextRed.c] == 'O') return 1;

                if(nextRed.r == nextBlue.r && nextRed.c == nextBlue.c) {
                    if (i == 0) {
                        if (cur.red.c > cur.blue.c) nextBlue.c -= 1; else nextRed.c -= 1;
                    } else if (i == 1) {
                        if (cur.red.c > cur.blue.c) nextRed.c += 1; else nextBlue.c += 1;
                    } else if (i == 2) {
                        if (cur.red.r > cur.blue.r) nextBlue.r -= 1; else nextRed.r -= 1;
                    } else if (i == 3) {
                        if (cur.red.r > cur.blue.r) nextRed.r += 1; else nextBlue.r += 1;
                    }
                }


                String state = nextRed.r + " " + nextRed.c + " " + nextBlue.r + " " + nextBlue.c;
                if (!visited.contains(state)) {
                    visited.add(state);
                    q.add(new Entry(nextRed, nextBlue, cur.distance + 1));
                }
            }
        }
        return 0;
    }

    private static Point move(Point start, int direction, Character[][] grid, int n, int m) {
        int r = start.r;
        int c = start.c;
        while (isValid(r + dr[direction], c + dc[direction], n, m) && grid[r + dr[direction]][c + dc[direction]] != '#') {
            r += dr[direction];
            c += dc[direction];
            if (grid[r][c] == 'O') break;
        }
        return new Point(r, c);
    }

    private static boolean isValid(int r, int c, int n, int m) {
        return (0 <= r && r < n) && (0 <= c && c < m);
    }

    public static class Entry {
        Point red;
        Point blue;
        int distance;

        public Entry(Point red, Point blue, int distance) {
            this.red = red;
            this.blue = blue;
            this.distance = distance;
        }
    }

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

//        @Override
//        public boolean equals(Object obj) {
//            if(this == obj) return true;
//            if (obj == null || getClass() != obj.getClass()) return false;
//            Point point = (Point) obj;
//            return r == point.r && c == point.c;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(r, c);
//        }
    }

}