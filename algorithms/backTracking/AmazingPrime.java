package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazingPrime {
	public static void main(String[] args) throws IOException {
		// 입력 기능: BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prime(N, 0, "");
	}

	private static void prime(int n, int depth, String s) {
		if (depth == n) {
			System.out.println(s);
		}

		for (Integer i = 1; i < 10; i++) {
			String str = s + i;

			if (isPrime(Integer.parseInt(str))) {
				prime(n, depth + 1, str);
			}
		}
	}

	private static boolean isPrime(int n) {
		if (n == 1) return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}

		return true;
	}
}
