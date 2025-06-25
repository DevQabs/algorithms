package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM3 {
	public static void main(String[] args) throws IOException {
		// 입력 기능: BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		// 입력값 확인 (문제 풀이용이 아니므로, 입력 기능만 작성)
		// System.out.println("N = " + N + ", M = " + M);

		// 아래는 2차원 배열 예시 선언 (문제 풀이용, 입력 기능과 별개)
		// int[][] arr = new int[N][M];

		int[] value = new int[M];
		nm(N, M, 0, value);
	}

	private static void nm(int n, int m, int depth, int[] value) {
		if (m == depth) {
			for (int i = 0; i < m; i++) {
				System.out.print(value[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			value[depth] = i;
			nm(n, m, depth + 1, value);
		}
	}

}
