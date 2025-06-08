package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class isLandCount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;

			int[][] map = new int[w][h];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			// 여기서 map, w, h를 이용해 섬의 개수를 세는 로직을 호출하면 됩니다.
			countIslands(w, h, map);
		}
	}

	static void countIslands(int weight, int height, int[][] map) {
		int[] nx = new int[] {0, -1, 1};
		int[] ny = new int[] {0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[weight][height];

		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0 || visited[i][j]) continue;

				count++;
				queue.add(new int[] {i, j});
				while (!queue.isEmpty()) {
					int[] location = queue.poll();

					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							if (x == 0 && y == 0) continue;

							int dx = location[0] + nx[x];
							int dy = location[1] + ny[y];

							if (dx < 0 || dy < 0 || dx >= weight || dy >= height) continue;
							if (visited[dx][dy]) continue;
							if (map[dx][dy] == 0) continue;

							visited[dx][dy] = true;
							queue.add(new int[] {dx, dy});
						}
					}
				}
			}
		}

		System.out.println(count);
	}
}
