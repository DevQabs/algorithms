package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			if (k == 0) break;

			int[] arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(input[i + 1]);
			}

			int[] list = new int[6];
			lotto(k, arr, list, 0, 0, new boolean[k]);
			System.out.println();
		}
	}

	private static void lotto(int k, int[] arr, int[] result, int depth, int index, boolean[] visited) {
		if (6 == depth) {
			for (int i = 0; i < 6; i++) {
				System.out.print(result[i] +  " ");
			}
			System.out.println();
			return;
		}

		for (int i = index; i < k; i++) {
			if(6 - depth > k - i ) continue;
			if (visited[i]) continue;
			result[depth] = arr[i];
			visited[i] = true;
			lotto(k, arr, result, depth + 1, i + 1, visited);
			visited[i] = false;
		}
	}
}
