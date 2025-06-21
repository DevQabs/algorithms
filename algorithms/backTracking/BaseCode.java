package backTracking;

import java.util.Scanner;

public class BaseCode {
	static int n, m;
	static int[] arr = new int[10];
	static boolean[] isUsed = new boolean[10];

	public static void func(int k) { // 현재 k개까지 수를 택했음
		if (k == m) { // m개를 모두 택했으면
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) { // 1부터 n까지의 수에 대해
			if (!isUsed[i]) { // 아직 i가 사용되지 않았으면
				arr[k] = i; // k번째 수를 i로 정함
				isUsed[i] = true; // i를 사용되었다고 표시
				func(k + 1); // 다음 수를 정하러 한 단계 더 들어감
				isUsed[i] = false; // i를 이제 사용되지 않았다고 명시함
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		func(0);
	}
}
