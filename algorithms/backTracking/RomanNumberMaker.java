package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RomanNumberMaker {

	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 예: 한 줄에 정수 하나 입력받기
		String line = br.readLine();
		int number = Integer.parseInt(line);

		Set<String> set = new HashSet<>();
		sum(number, 0, 0, set);
		System.out.println(count);
	}

	private static int[] romanNumber = {1, 5, 10, 50};
	private static void sum(int number, int romanNumberCount, int romanSum, Set<String> set) {
		if (romanNumberCount == number) {
			count++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int sum = romanSum + romanNumber[i];
			if (!set.add(romanNumberCount + "_ " + sum)) continue;
			sum(number, romanNumberCount + 1, sum, set);
		}
	}
}
