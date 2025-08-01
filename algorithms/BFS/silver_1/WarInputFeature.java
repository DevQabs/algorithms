package BFS.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 전투 (1303)
 *
 * https://www.acmicpc.net/problem/1303
 */
public class WarInputFeature {
	public static void main(String[] args) throws IOException {
		// 입력을 위한 BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 번째 줄에서 가로(N), 세로(M) 입력 받기
		String[] nm = br.readLine().split(" ");
		int M = Integer.parseInt(nm[0]); // 가로
		int N = Integer.parseInt(nm[1]); // 세로

		// 2차원 배열로 전장 정보 저장
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 입력 테스트를 위한 출력 (입력기능만 요구시 아래부분 삭제 가능)
		// for (int i = 0; i < M; i++) {
		//     for (int j = 0; j < N; j++) {
		//         System.out.print(map[i][j]);
		//     }
		//     System.out.println();
		// }

		solution(N, M, map);

		br.close();
	}

// 5 5
// WBWWW
// WWWWW
// BBBBB
// BBBWW
// WWWWW
	private static void solution(int n, int m, char[][] map) {
		// bfs(n, m, map);
		dfs(map);
	}


	static boolean[][] visited;
	private static void dfs(char[][] map) {
		visited = new boolean[map.length][map[0].length];

		int whitePower = 0;
		int blackPower = 0;

		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				if (visited[y][x]) continue;

				visited[y][x] = true;
				int count = dfs(y, x, map);

				if (map[y][x] == 'W') {
					whitePower += count * count;
				} else {
					blackPower += count * count;
				}
			}
		}

		System.out.println(whitePower + " " + blackPower);
	}

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	private static int dfs(int curY, int curX, char[][] map) {
		int count = 1;
		for (int l = 0; l < 4; l++) {
			int ny = dy[l] + curY;
			int nx = dx[l] + curX;

			if (nx < 0 || ny < 0 || ny >= map.length || nx >= map[ny].length) continue;
			if (visited[ny][nx] || map[ny][nx] != map[curY][curX]) continue;

			visited[ny][nx] = true;
			count += dfs(ny, nx, map);
		}

		return count;
	}

	private static void bfs(int n, int m, char[][] map) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new ArrayDeque();

		int whitePower = 0;
		int blackPower = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (visited[y][x]) continue;

				visited[y][x] = true;
				queue.add(new int[] {y, x});
				int count = 1;

				while(!queue.isEmpty()) {
					int[] pos = queue.poll();
					int curY = pos[0];
					int curX = pos[1];

					for (int l = 0; l < 4; l++) {
						int ny = dy[l] + curY;
						int nx = dx[l] + curX;

						if (nx < 0 || ny < 0 || ny >= map.length || nx >= map[curY].length) continue;
						if (visited[ny][nx]) continue;
						if (map[ny][nx] != map[curY][curX]) continue;

						count++;
						visited[ny][nx] = true;
						queue.add(new int[] {ny, nx});
					}
				}

				int power = count * count;
				if (map[y][x] == 'W') {
					whitePower += power;
				} else {
					blackPower += power;
				}
			}
		}

		System.out.println(whitePower + " " + blackPower);
	}
}
