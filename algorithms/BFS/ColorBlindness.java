package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ColorBlindness {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 그림의 크기

		char[][] picture = new char[n][n]; // 2차원 배열로 그림 정보 저장
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				picture[i][j] = line.charAt(j);
			}
		}

		// 입력 확인용 (주석 처리 가능)
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < n; j++) {
		//         System.out.print(picture[i][j]);
		//     }
		//     System.out.println();
		// }

		// picture 배열을 이용해 알고리즘을 구현하시면 됩니다.
		bfs(n, picture);

		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        if (picture[i][j] == 'G') picture[i][j] = 'R';
		    }
		}

		bfs(n, picture);
	}

	static void bfs(int n, char[][] picture) {
		boolean[][] visited = new boolean[picture.length][picture.length];
		Queue<int[]> queue = new LinkedList<>();

		int[] nx = {-1, 1, 0, 0};
		int[] ny = {0, 0, -1, 1};

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) continue;

				count++;
				visited[i][j] = true;
				queue.add(new int[] {i, j});
				while (!queue.isEmpty()) {
					int[] location = queue.poll();

					for (int z = 0; z < 4; z++) {
						int dx = nx[z] + location[0];
						int dy = ny[z] + location[1];

						if (dx >= picture.length || dy >= picture[0].length || dx < 0 || dy < 0) continue;
						if (visited[dx][dy]) continue;
						if (picture[dx][dy] != picture[location[0]][location[1]]) continue;

						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}
				}
			}
		}

		System.out.print(count + " ");
	}
}
