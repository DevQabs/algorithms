package backTracking.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암호 만들기 (1759)
 *
 * https://www.acmicpc.net/problem/1759
 */
public class PasswordMaker {
	static int L, C;
	static char[] arr;  // 주어진 알파벳
	static char[] password;  // 현재 선택한 암호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력: L, C
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 두 번째 줄 입력: 알파벳 문자 배열
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);  // 암호 사전 순 출력을 위해 정렬
		password = new char[L];

		// 이 후 조합이나 백트래킹 함수 호출 가능
		dfs(0, 0);
	}

	private static void dfs(int depth, int start) {
		if (depth == L) {
			if (!isValidPassword(password)) {
				return;
			}

			for (char p : password) {
				System.out.print(p);
			}
			System.out.println();
			return;
		}

		for (int i = start; i < C; i++) {
			password[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
	}

	private static boolean isValidPassword(char[] password) {
		boolean isVowel = false;
		int consonantCount = 0;

		for (char p : password) {
			if (p == 'a' || p == 'e' || p == 'i' || p == 'o' || p == 'u') {
				isVowel = true;
			} else {
				consonantCount++;
			}
		}

		return isVowel && consonantCount > 1;
	}
}
