package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cabbage {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer testToken = new StringTokenizer(br.readLine());
		Integer testCount = Integer.valueOf(testToken.nextToken());

		for (int i = 0; i < testCount; i++) {
			StringTokenizer caseToken = new StringTokenizer(br.readLine());
			Integer x = Integer.valueOf(caseToken.nextToken());
			Integer y = Integer.valueOf(caseToken.nextToken());
			Integer cabbageCount = Integer.valueOf(caseToken.nextToken());

			int[][] cabbageLocation = new int[x][y];
			for (int j = 0; j < cabbageCount; j++) {
				StringTokenizer cabbageToken = new StringTokenizer(br.readLine());
				int dx = Integer.valueOf(cabbageToken.nextToken());
				int dy = Integer.valueOf(cabbageToken.nextToken());

				cabbageLocation[dx][dy] = 1;
			}

			bfs(x, y, cabbageLocation);
		}
	}

	static void bfs(int x, int y, int[][] cabbageLocations) {
		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};

		boolean[][] visited = new boolean[x][y];
		Queue<int[]> queue = new LinkedList<>();

		int count = 0;
		for (int i = 0; i < cabbageLocations.length; i++) {
			for (int j = 0; j < cabbageLocations[i].length; j++) {
				int cabbageLocation = cabbageLocations[i][j];

				if (visited[i][j] || cabbageLocation != 1) {
					continue;
				}

				count++;

				visited[i][j] = true;
				queue.add(new int[] {i, j});

				while(!queue.isEmpty()) {
					int[] location = queue.poll();

					for (int q = 0; q < 4; q++) {
						int dx = nx[q] + location[0];
						int dy = ny[q] + location[1];

						if (dx >= x || dy >= y || dx < 0 || dy < 0) continue;
						if (visited[dx][dy]) continue;
						if (cabbageLocations[dx][dy] != 1) continue;

						// 방문처리는 큐에 넣을 때 할 것 (중복 호출 방지)
						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}
				}
			}
		}

		System.out.println(count);

	}

}
