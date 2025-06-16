package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayRotation3Input {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 크기 N, M, 연산의 개수 R 입력
		String[] nmr = br.readLine().split(" ");
		int n = Integer.parseInt(nmr[0]);
		int m = Integer.parseInt(nmr[1]);
		int r = Integer.parseInt(nmr[2]);

		// 2차원 배열 입력
		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(row[j]);
			}
		}

		// 연산 배열 입력
		String[] operationsStr = br.readLine().split(" ");
		int[] operations = new int[r];
		for (int i = 0; i < r; i++) {
			operations[i] = Integer.parseInt(operationsStr[i]);
		}

		// 입력 확인 출력 (필요시)
		// System.out.println("배열:");
		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(array[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.print("연산: ");
		// for (int op : operations) {
		// 	System.out.print(op + " ");
		// }

		rotation(n, m, operations, array);
	}

	public static int[][] deepCopy(int[][] original) {
		if (original == null) return null;
		int[][] result = new int[original.length][];
		for (int i = 0; i < original.length; i++) {
			result[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return result;
	}

	private static void rotation(int n, int m, int[] operations, int[][] array) {
		for (int operation : operations) {
			int[][] newArray = deepCopy(array);

			// 상하
			if (operation == 1) {
				for (int r = n - 1; r >= 0; r--) {
					for (int c = 0; c < m; c++) {
						array[(n - 1) - r][c] = newArray[r][c];
					}
				}
			}

			// 좌우
			if (operation == 2) {
				for (int r = 0; r < n; r++) {
					for (int c = m - 1; c >= 0; c--) {
						array[r][(m - 1) - c] = newArray[r][c];
					}
				}
			}

			// 오른쪽 90도
			if (operation == 3) {
				array = new int[m][n];
				for (int c = 0; c < m; c++) {
					for (int r = n - 1; r >= 0; r--) {
						array[c][(n - 1) - r] = newArray[r][c];
					}
				}

				int temp = m;
				m = n;
				n = temp;
			}

			// 왼쪽 90도
			if (operation == 4) {
				array = new int[m][n];
				for (int c = m - 1; c >= 0; c--) {
					for (int r = 0; r < n; r++) {
						array[(m - 1) - c][r] = newArray[r][c];
					}
				}

				int temp = m;
				m = n;
				n = temp;
			}

			// 4개로 나눔 -> 오른쪽으로
			if (operation == 5) {
				int n2 = n / 2;
				int m2 = m / 2;

				// 1 → 2
				for (int i = 0; i < n2; i++) {
					for (int j = 0; j < m2; j++) {
						array[i][j + m2] = newArray[i][j];
					}
				}
				// 2 → 3
				for (int i = 0; i < n2; i++) {
					for (int j = m2; j < m; j++) {
						array[i + n2][j] = newArray[i][j];
					}
				}
				// 3 → 4
				for (int i = n2; i < n; i++) {
					for (int j = m2; j < m; j++) {
						array[i][j - m2] = newArray[i][j];
					}
				}
				// 4 → 1
				for (int i = n2; i < n; i++) {
					for (int j = 0; j < m2; j++) {
						array[i - n2][j] = newArray[i][j];
					}
				}
			}

			// 4개로 나눔 -> 왼쪽으로
			if (operation == 6) {
				int n2 = n / 2;
				int m2 = m / 2;

				// 1 → 4
				for (int i = 0; i < n2; i++) {
					for (int j = 0; j < m2; j++) {
						array[i + n2][j] = newArray[i][j];
					}
				}
				// 4 → 3
				for (int i = n2; i < n; i++) {
					for (int j = 0; j < m2; j++) {
						array[i][j + m2] = newArray[i][j];
					}
				}
				// 3 → 2
				for (int i = n2; i < n; i++) {
					for (int j = m2; j < m; j++) {
						array[i - n2][j] = newArray[i][j];
					}
				}
				// 2 → 1
				for (int i = 0; i < n2; i++) {
					for (int j = m2; j < m; j++) {
						array[i][j - m2] = newArray[i][j];
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}


	}
}
