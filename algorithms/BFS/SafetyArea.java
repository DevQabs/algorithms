package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafetyArea {

	public static void main(String[] args) throws IOException {
		// 입력을 빠르게 받기 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄에서 N(지역의 크기) 입력 받기
		int N = Integer.parseInt(br.readLine());

		// 2차원 배열 생성
		int[][] map = new int[N][N];

		// N줄에 걸쳐 각 행의 높이 정보 입력 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// (확인용) 입력받은 2차원 배열 출력
		int max = 1;
		for (int i = 1; i <= 100; i++) {
			int safetyArea = bfs(i, map);
			if (safetyArea == 0) {
				break;
			}

			max = Integer.max(max, safetyArea);
		}

		System.out.println(max);
	}

	static int bfs(int rainHeight, int[][] map) {
		int[] nx = new int[] {-1, 1, 0, 0};
		int[] ny = new int[] {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map.length];

		int count = 0;
		// 높이 낮은 것들은 전부 0 처리
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (rainHeight >= map[i][j]) continue;
				if (visited[i][j]) continue;

				count++;
				queue.add(new int[] {i, j});

				while(!queue.isEmpty()) {
					int[] area = queue.poll();

					for (int x = 0; x < 4; x++) {
						int dx = nx[x] + area[0];
						int dy = ny[x] + area[1];

						if (dx >= map.length || dy >= map.length || dx < 0 || dy < 0) continue;
						if (visited[dx][dy]) continue;
						if (rainHeight >= map[dx][dy]) continue;

						visited[dx][dy] = true;
						queue.add(new int[] {dx, dy});
					}
				}

			}
		}

		return count;
	}

}
