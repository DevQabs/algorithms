package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravelingSalesman2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫째 줄: 도시의 수 N
		int N = Integer.parseInt(br.readLine());

		// N x N 비용 행렬 입력
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[N];
		for (int j = 1; j < N; j++) {
			if (map[0][j] == 0 || visited[j]) continue;
			visited[j] = true;
			travel(N, map, j, visited, 1, map[0][j]);
			visited[j] = false;
		}

		System.out.println(minCost);
	}

	private static int minCost = Integer.MAX_VALUE;

	private static void travel(int n, int[][] map, int to, boolean[] visited, int depth, int cost) {
		if (depth == n && to == 0) {
			minCost = Integer.min(minCost, cost);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (map[to][i] == 0 || to == i || visited[i]) continue;
			visited[i] = true;
			travel(n, map, i, visited, depth + 1, cost + map[to][i]);
			visited[i] = false;
		}
	}
}
