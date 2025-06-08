package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer computerTokenizer = new StringTokenizer(br.readLine());
		Integer computerCount = Integer.valueOf(computerTokenizer.nextToken());

		StringTokenizer networkTokenizer = new StringTokenizer(br.readLine());
		Integer networkCount = Integer.valueOf(networkTokenizer.nextToken());

		int[][] lines = new int[networkCount][2];
		for (int i = 0; i < networkCount; i++) {
			StringTokenizer networkLineTokenizer = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(networkLineTokenizer.nextToken());
			int to = Integer.valueOf(networkLineTokenizer.nextToken());
			lines[i][0] = from;
			lines[i][1] = to;
		}

		solution(computerCount, lines);
	}

	static void solution(int computerCount, int[][] lines) {
		boolean[] isInfected = new boolean[computerCount + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while(!queue.isEmpty()) {
			Integer infectedComputer = queue.poll();
			isInfected[infectedComputer] = true;

			for (int i = 0; i < lines.length; i++) {
				int from = lines[i][0];
				int to = lines[i][1];

				if (from == infectedComputer && !isInfected[to]) {
					queue.add(to);
				}

				if (to == infectedComputer && !isInfected[from]) {
					queue.add(from);
				}
			}
		}

		int count = 0;
		for (int i = 0 ; i < isInfected.length ; i++) {
			if (isInfected[i]) count++;
		}

		System.out.println(count - 1);
	}


}
