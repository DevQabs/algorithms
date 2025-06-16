package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PCBang {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 손님의 수 입력
		int n = Integer.parseInt(br.readLine());

		// 손님이 원하는 자리 번호 입력 (공백 구분)
		String[] input = br.readLine().split(" ");
		int[] seats = new int[n];
		for (int i = 0; i < n; i++) {
			seats[i] = Integer.parseInt(input[i]);
		}

		// 입력 확인 출력
		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : seats) {
			if (!set.add(i)) {
				count++;
			}
		}

		System.out.println(count);
	}
}
