package implementation;

import java.util.HashSet;
import java.util.Set;

public class LineLength {

	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}

	public static int solution(String dirs) {
		Set<String> visited = new HashSet<>();
		int x = 0;
		int y = 0;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		String directions = "UDLR";

		for (char dir : dirs.toCharArray()) {
			int idx = directions.indexOf(dir);
			int nx = x + dx[idx];
			int ny = y + dy[idx];

			if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

			String path = x + "," + y + "," + nx + "," + ny;
			String reversePath = nx + "," + ny + "," + x +"," + y;

			visited.add(path);
			visited.add(reversePath);

			x = nx;
			y = ny;
		}

		return visited.size() / 2;
	}

}
