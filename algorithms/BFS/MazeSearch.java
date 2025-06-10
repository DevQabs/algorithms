package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MazeSearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력: N(행), M(열)
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		// 미로 정보 입력 (2차원 배열)
		int[][] maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		// 입력 확인용 (주석 처리 또는 삭제 가능)
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < m; j++) {
		//         System.out.print(maze[i][j]);
		//     }
		//     System.out.println();
		// }

		bfs(maze);
	}

	static void bfs(int[][] maze) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		maze[0][0] = 0;

		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};
		int[][] distance = new int[maze.length][maze[0].length];
		distance[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] location = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = nx[i] + location[0];
				int dy = ny[i] + location[1];

				if (dx >= maze.length || dy >= maze[0].length || dx < 0 || dy < 0) continue;
				if (maze[dx][dy] == 0) continue;

				maze[dx][dy] = 0;

				if (distance[dx][dy] != 0) {
					distance[dx][dy] = Integer.min(distance[dx][dy], distance[location[0]][location[1]] + 1);
				} else {
					distance[dx][dy] = distance[location[0]][location[1]] + 1;
				}
				queue.add(new int[] {dx, dy});
			}
		}

		System.out.println(distance[maze.length - 1][maze[0].length - 1]);
	}
}
