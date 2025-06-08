package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectCount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수

		// 인접 행렬(2차원 배열) 생성 (정점 번호 1~n)
		int[][] graph = new int[n][n];

		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			--u;
			--v;
			graph[u][v] = 1;
			graph[v][u] = 1; // 무방향 그래프이므로 양방향 표시
		}

		int count = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				visited[i] = true;
				bfs(n, i, visited, graph);
			}
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) count++;
		}

		System.out.println(count);

		// bfs(n, m, graph);
	}

	static void bfs(int n, int start, boolean[] visited, int[][] graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while(!queue.isEmpty()) {
			int point = queue.poll();
			for (int i = 0; i < n; i++) {
				if (graph[point][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	// static void bfs(int n, int m, int[][] graph) {
	// 	boolean[] dotVisited = new boolean[n];
	// 	boolean[][] visited = new boolean[graph.length][graph.length];
	// 	Queue<int[]> queue = new LinkedList<>();
	//
	// 	int count = 0;
	// 	for (int i = 0; i < graph.length; i++) {
	// 		for (int j = 0; j < graph[i].length; j++) {
	// 			if (visited[i][j]) continue;
	// 			if (graph[i][j] == 0) continue;
	//
	// 			count++;
	// 			visited[i][j] = true;
	// 			visited[j][i] = true;
	// 			dotVisited[i] = true;
	// 			dotVisited[j] = true;
	// 			queue.add(new int[] {i, j});
	//
	// 			while (!queue.isEmpty()) {
	// 				int[] line = queue.poll();
	// 				int x = line[0];
	// 				int y = line[1];
	//
	// 				for (int z = 0; z < n; z++) {
	// 					if (graph[x][z] == 1 && !visited[x][z]) {
	// 						visited[x][z] = true;
	// 						visited[z][x] = true;
	// 						dotVisited[x] = true;
	// 						dotVisited[z] = true;
	// 						queue.add(new int[] {x, z});
	// 					}
	//
	// 					if (graph[y][z] == 1 && !visited[y][z]) {
	// 						visited[y][z] = true;
	// 						visited[z][y] = true;
	// 						dotVisited[y] = true;
	// 						dotVisited[z] = true;
	// 						queue.add(new int[] {y, z});
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}
	//
	// 	for (int i = 0; i < dotVisited.length; i++) {
	// 		if (!dotVisited[i]) count++;
	// 	}
	// 	System.out.println(count);
	// }
}
