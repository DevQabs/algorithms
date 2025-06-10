package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMove {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		int[] sizes = new int[t];
		int[][] start = new int[t][2];
		int[][] end = new int[t][2];

		for (int i = 0; i < t; i++) {
			sizes[i] = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
			String[] startPos = br.readLine().split(" ");
			start[i][0] = Integer.parseInt(startPos[0]);
			start[i][1] = Integer.parseInt(startPos[1]);
			String[] endPos = br.readLine().split(" ");
			end[i][0] = Integer.parseInt(endPos[0]);
			end[i][1] = Integer.parseInt(endPos[1]);
		}

		// 예시: 각 테스트케이스 입력 출력 (주석 처리 가능)
		// for (int i = 0; i < t; i++) {
		//     System.out.println("size: " + sizes[i]);
		//     System.out.println("start: " + start[i][0] + " " + start[i][1]);
		//     System.out.println("end: " + end[i][0] + " " + end[i][1]);
		// }

		// 이제 아래와 같이 매개변수로 넘겨 사용할 수 있습니다.
		for (int i = 0; i < t; i++) {
		    knightBFS(sizes[i], start[i], end[i]);
		}
	}

	private static void knightBFS(int size, int[] start, int[] end) {
		// 상 하 좌 우 2 칸 후 양 옆으로 한 칸
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start[0], start[1], 0});

		int[] nx = {-2, -2, 2, 2, -1, -1, 1, 1};
		int[] ny = {1, -1, 1, -1, 2, -2, 2, -2};
		boolean[][] visited = new boolean[size][size];

		while(!queue.isEmpty()) {
			int[] location = queue.poll();

			if (location[0] == end[0] && location[1] == end[1]) {
				System.out.println(location[2]);
				return;
			}

			for (int i = 0; i < nx.length; i++) {
				int dx = nx[i] + location[0];
				int dy = ny[i] + location[1];

				if (dx >= size || dy >= size || dx < 0 || dy < 0) continue;
				if (visited[dx][dy]) continue;;

				visited[dx][dy] = true;
				queue.add(new int[] {dx, dy, location[2] + 1});
			}
		}
	}
}
