package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄: 세로(N), 가로(M) 입력
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		// N x M 숫자판 입력 (문자 그대로 저장)
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		// 입력 확인 출력 (필요시)
		System.out.println("입력된 숫자판:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

		numberSquare(n, m, board);
	}

	private static void numberSquare(int n, int m, char[][] board) {

		int max = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				for (int i = 0; i < n && i < m; i++) {
					if (r + i >= n || c + i >= m) break;
					if (board[r][c] == board[r + i][c + i] && board[r][c + i] == board[r + i][c] && board[r][c] == board[r][c + i]) {
						max = Integer.max(max, i);
					}
				}
			}
		}

		max++;
		System.out.println(max * max);
	}
}
