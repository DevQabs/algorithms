package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDistance {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}};

		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,1});

		int[] upDown = {-1, 1, 0, 0};
		int[] leftRight = {0, 0, -1, 1};

		while(!queue.isEmpty()) {
			int[] location = queue.poll();
			if (location[0] == maps.length - 1 && location[1] == maps[0].length - 1) return location[2];

			for (int i = 0; i < 4; i++) {
				int dx = location[0] + upDown[i];
				int dy = location[1] + leftRight[i];

				if (dx >= 0 && dy >= 0 && dx < maps.length && dy < maps[0].length && maps[dx][dy] == 1) {
					maps[dx][dy] = 0;
					queue.add(new int[]{dx, dy, location[2]+1});
				}
			}
		}

		return -1;
	}

}
