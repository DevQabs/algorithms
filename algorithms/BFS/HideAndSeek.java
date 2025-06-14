package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int N = Integer.parseInt(tokens[0]);
		int K = Integer.parseInt(tokens[1]);

		hideAndSeek(N, K);
	}

	private static void hideAndSeek(int n, int k) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n, 0});

		int min = Integer.MAX_VALUE;

		boolean[] visited = new boolean[100_001];
		visited[n] = true;

		while (!queue.isEmpty()) {
			int[] arr = queue.remove();
			int location = arr[0];
			int time = arr[1];

			if (location == k) {
				min = Integer.min(min, time);
				break;
			}

			int[] next = {location -1, location * 2, location + 1};
			for (int i = 0; i < next.length; i++) {
				int nextStep = next[i];

				if (nextStep > 100_000 || nextStep < 0 || visited[nextStep]) continue;

				visited[nextStep] = true;
				queue.add(new int[] {nextStep, time + 1});
			}
		}

		System.out.println(min);
	}
}
