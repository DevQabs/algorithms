package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BridgeMaking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄: 지도의 크기 N 입력
		int N = Integer.parseInt(br.readLine());

		// N x N 지도 배열 선언
		int[][] map = new int[N][N];

		// 지도 정보 입력
		for (int i = 0; i < N; i++) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		// 입력 확인 (테스트용)
		// for (int[] row : map) {
		//     for (int cell : row) {
		//         System.out.print(cell + " ");
		//     }
		//     System.out.println();
		// }

		bridgeMaking(N, map);

	}

	static int[] nx = new int[] {-1, 1, 0, 0};
	static int[] ny = new int[] {0, 0, -1, 1};

	private static void bridgeMaking(int n, int[][] map) {
		edge(n, map);
	}

	private static void edge(int n, int[][] map) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int[][] land = new int[n][n];

		int landNo = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (map[y][x] == 0 || visited[y][x]) continue;

				queue.add(new int[] {x, y});
				visited[y][x] = true;
				land[y][x] = ++landNo;

				while(!queue.isEmpty()) {
					int[] location = queue.poll();
					boolean isEdge = false;

					for (int z = 0; z < 4; z++) {
						int dx = nx[z] + location[0];
						int dy = ny[z] + location[1];

						if (dx >= n || dy >= n || dx < 0 || dy < 0) continue;
						if (visited[dy][dx]) continue;
						if (map[dy][dx] == 0) {
							isEdge = true;
							continue;
						}

						visited[dy][dx] = true;
						queue.add(new int[] {dx, dy});
					}

					if (isEdge) {
						land[location[1]][location[0]] = landNo;
					} else {
						land[location[1]][location[0]] = -1;
					}
				}
			}
		}

		int minimumDistance = Integer.MAX_VALUE;
		Queue<int[]> edgeQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (land[i][j] <= 0) continue;
				edgeQueue.add(new int[] {j, i});

				int[][] distance = new int[n][n];
				distance[i][j] = 1;
				while(!edgeQueue.isEmpty()) {
					int[] location = edgeQueue.poll();

					for (int z = 0; z < 4; z++) {
						int dx = nx[z] + location[0];
						int dy = ny[z] + location[1];

						if (dx >= n || dy >= n || dx < 0 || dy < 0) continue;
						if (land[dy][dx] == -1 || land[dy][dx] == land[i][j] || distance[dy][dx] > 0) continue;

						distance[dy][dx] = distance[location[1]][location[0]] + 1;
						edgeQueue.add(new int[] {dx, dy});

						if (land[dy][dx] > 0 && land[dy][dx] != land[i][j]) {
							minimumDistance = Integer.min(minimumDistance, distance[dy][dx]);
						}
					}
				}
		    }
		}

		System.out.println(minimumDistance - 2);
	}
}
