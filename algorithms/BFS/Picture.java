package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Picture {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] picture = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 확인용 출력 (테스트용, 제출 시 삭제)
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < m; j++) {
		//         System.out.print(picture[i][j] + " ");
		//     }
		//     System.out.println();
		// }

		picture(n, m, picture);
	}

	private static void picture(int n, int m, int[][] picture) {
		Queue<int[]> queue = new LinkedList<>();

		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};

		int land = 0;
		int maxLandSize = 0;

		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (picture[i][j] == 0 || visited[i][j]) continue;

				int count = 1;

				land++;
				queue.add(new int[] {i, j});
				visited[i][j] = true;

				while(!queue.isEmpty()) {
					int[] area = queue.poll();

					for (int x = 0; x < 4; x++) {
						int dx = nx[x] + area[0];
						int dy = ny[x] + area[1];

						if (dx >= n || dy >= m || dx < 0 || dy < 0) continue;
						if (visited[dx][dy] || picture[dx][dy] == 0) continue;

						count++;
						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}
				}

				maxLandSize = Integer.max(maxLandSize, count);
			}
		}

		System.out.println(land);
		System.out.println(maxLandSize);

	}
}
