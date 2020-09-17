package test.jindong_0917;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class _02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String t = sc.nextLine();
            int n = Integer.parseInt(t.split(" ")[0]);
            int m = Integer.parseInt(t.split(" ")[1]);
            String[][] maps = new String[n][m];

            for (int j = 0; j < n; j++) {
                String tmp = sc.nextLine();
                for (int k = 0; k < m; k++) {
                    maps[j][k] = tmp.charAt(k) + "";
                }
            }

            int[] start = find(maps, "S");
            int[] end = find(maps, "E");

            if (start[0] == -1 || start[1] == -1 || end[0] == -1 || end[1] == -1) {
                System.out.println("NO");
                continue;
            }

            boolean res = judge(maps, start[0], start[1], end);
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean judge(String[][] maps, int i, int j, int[] end) {

        if (i == end[0] && j == end[1]) {
            return true;
        }

        if (i < 0 || i >= maps.length || j < 0 || j >= maps[0].length
                || "#".equals(maps[i][j])
                || "@".equals(maps[i][j])) {
            return false;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        maps[i][j] = "@";
        for (int[] direction : directions) {
            if (judge(maps, i + direction[0], j + direction[1], end)) {
                return true;
            }
        }
        maps[i][j] = ".";

        return false;
    }

    private static int[] find(String[][] maps, String type) {

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j].equals(type)) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {-1, -1};
    }
}
