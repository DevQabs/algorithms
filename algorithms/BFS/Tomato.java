package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mn = br.readLine().split(" ");
		int m = Integer.parseInt(mn[0]); // 가로(열)
		int n = Integer.parseInt(mn[1]); // 세로(행)

		int[][] box = new int[n][m]; // 2차원 배열로 토마토 상태 저장
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 입력 확인용 (주석 처리 가능)
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < m; j++) {
		//         System.out.print(box[i][j] + " ");
		//     }
		//     System.out.println();
		// }

		// box 배열을 이용해 알고리즘을 구현하시면 됩니다.
		bfs(box);
	}

	private static void bfs(int[][] box) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[box.length][box[0].length];

		int[] nx = {-1, 1, 0, 0};
		int[] ny = {0, 0, -1, 1};

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] >= 1) {
					if (visited[i][j]) continue;

					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] location = queue.poll();

			for (int z = 0; z < 4; z++) {
				int dx = nx[z] + location[0];
				int dy = ny[z] + location[1];

				if (dx >= box.length || dy >= box[0].length || dx < 0 || dy < 0) continue;
				if (visited[dx][dy]) continue;
				if (box[dx][dy] == -1) continue;
				if (box[dx][dy] >= 1) continue;

				box[dx][dy] = box[location[0]][location[1]] + 1;
				visited[dx][dy] = true;

				queue.add(new int[] {dx, dy});
			}
		}

		// 입력 확인용 (주석 처리 가능)
		int days = Integer.MIN_VALUE;
		for (int i = 0; i < box.length; i++) {
		    for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				days = Integer.max(days, box[i][j]);
		    }
		}

		System.out.println(days - 1);
	}

}
