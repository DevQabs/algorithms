package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Laboratory {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]); // 연구소 세로 크기
		int m = Integer.parseInt(nm[1]); // 연구소 가로 크기

		int[][] lab = new int[n][m]; // 연구소 상태 저장
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				lab[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 입력 확인용 (주석 처리 가능)
		// for (int i = 0; i < n; i++) {
		//     for (int j = 0; j < m; j++) {
		//         System.out.print(lab[i][j] + " ");
		//     }
		//     System.out.println();
		// }

		// lab 배열과 n, m을 활용해 알고리즘을 구현하시면 됩니다.
		bfs(n, m, lab);
	}

	private static void bfs(int n, int m, int[][] lab) {
		List<int[]> list = new ArrayList<>();
		List<int[]> virus = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lab[i][j] == 0) list.add(new int[] {i, j});
				if (lab[i][j] == 2) virus.add(new int[] {i, j});
			}
		}

		int max = 0;
		for (int x = 0; x < list.size(); x++) {
			for (int y = x + 1; y < list.size(); y++) {
				for (int z = y + 1; z < list.size(); z++) {
					int[] wall_1 = list.get(x);
					int[] wall_2 = list.get(y);
					int[] wall_3 = list.get(z);

					lab[wall_1[0]][wall_1[1]] = 1;
					lab[wall_2[0]][wall_2[1]] = 1;
					lab[wall_3[0]][wall_3[1]] = 1;

					max = Integer.max(max, queue(virus, n, m, lab));

					lab[wall_1[0]][wall_1[1]] = 0;
					lab[wall_2[0]][wall_2[1]] = 0;
					lab[wall_3[0]][wall_3[1]] = 0;
				}
			}
		}

		System.out.println(max);
	}

	static int queue(List<int[]> virus, int n, int m, int[][] lab) {
		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
			visited[virus.get(i)[0]][virus.get(i)[1]] = true;
		}

		while (!queue.isEmpty()) {
			int[] area = queue.poll();

			for (int s = 0; s < 4; s++) {
				int dx = nx[s] + area[0];
				int dy = ny[s] + area[1];

				if (dx >= n || dy >= m || dx < 0 || dy < 0) continue;
				if (visited[dx][dy] || lab[dx][dy] == 1) continue;

				visited[dx][dy] = true;
				queue.add(new int[] {dx, dy});
			}
		}

		int count = 0;
		for (int q = 0; q < n; q++) {
			for (int w = 0; w < m; w++) {
				if (lab[q][w] == 0 && !visited[q][w])
					count++;
			}
		}

		return count;
	}
}
