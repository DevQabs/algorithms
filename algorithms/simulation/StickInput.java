package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StickInput {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 막대기 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 막대기 길이 입력 (공백 구분)
		List<Integer> list = new ArrayList<>();
		for (int i = 64; i > 0; i /= 2) {
			list.add(i);
		}

		int count = 0;
		for (Integer stick : list) {
			if (n >= stick) {
				n -= stick;
				count++;
			}

			if (n == 0) {
				System.out.println(count);
				return;
			}
		}
	}
}
