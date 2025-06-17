package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorPaper {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 색종이 좌표 입력 (각 줄에 x y)
		int[][] papers = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] xy = br.readLine().split(" ");
			papers[i][0] = Integer.parseInt(xy[0]);
			papers[i][1] = Integer.parseInt(xy[1]);
		}

		// 입력 확인 출력
		// for (int i = 0; i < n; i++) {
		// 	System.out.println(papers[i][0] + " " + papers[i][1]);
		// }

		colorPaper(n, papers);
	}

	private static void colorPaper(int n, int[][] papers) {
		int count = 0;
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					int x = papers[i][0];
					int y = papers[i][1];

					int endX = papers[i][0] + 10;
					int endY = papers[i][1] + 10;

					if (r >= y && r < endY && c >= x && c < endX) {
						if (set.add(Arrays.asList(r, c))) {
							count++;
						}
					}
				}
			}
		}

		System.out.println(count);
	}
}
