package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubSequenceSum {

	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 번째 줄: N(정수의 개수), S(부분수열의 합)
		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int S = Integer.parseInt(firstLine[1]);

		// 두 번째 줄: N개의 정수 배열 입력
		String[] secondLine = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(secondLine[i]);
		}

		sum(N, S, 0, 0, arr);
		System.out.println(result);

	}

	private static void sum(int n, int s, int k, int x, int[] arr) {
		if (x > 0 && k == s) {
			result++;
			if (x == n) return;
		}

		for (int i = x; i < n; i++) {
			sum(n, s, k + arr[i], i + 1, arr);
		}
	}
}
