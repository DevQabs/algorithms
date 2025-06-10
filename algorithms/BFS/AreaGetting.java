package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AreaGetting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력: M(세로), N(가로), K(직사각형 개수)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 2차원 배열 선언 (0: 빈칸, 1: 직사각형)
		int[][] map = new int[M][N];

		// K개의 직사각형 입력받아 map에 표시
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 좌표에 해당하는 영역을 1로 채움
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		bfs(map);
	}

	static void bfs(int[][] map) {
		boolean[][] visited = new boolean[map.length][map[0].length];
		Queue<int[]> queue = new LinkedList<>();
		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};

		int land = 0;
		List<Integer> landSizes = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 || visited[i][j]) continue;

				land++;
				int landSize = 1;
				visited[i][j] = true;
				queue.add(new int[] {i, j});
				while(!queue.isEmpty()) {
					int[] location = queue.poll();

					for (int x = 0; x < 4; x++) {
						int dx = nx[x] + location[0];
						int dy = ny[x] + location[1];

						if (dx >= map.length || dy >= map[location[0]].length || dx < 0 || dy < 0) continue;
						if (visited[dx][dy] || map[dx][dy] == 1) continue;

						landSize++;
						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}
				}
				landSizes.add(landSize);
			}
		}

		System.out.println(land);
		landSizes = landSizes.stream().sorted(Integer::compareTo).collect(Collectors.toList());
		for (Integer size : landSizes) {
			System.out.print(size + " ");
		}
	}
}
