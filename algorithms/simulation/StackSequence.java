package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄: 수열의 길이 n 입력
		int n = Integer.parseInt(br.readLine());

		// n개의 수열 입력 (1차원 배열)
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}

		stack(n, sequence);
	}

	private static void stack(int n, int[] sequence) {

		Stack<Integer> stack = new Stack<>();
		stack.push(1);

		int index = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");

			while(true) {
				if (stack.isEmpty() || stack.peek() != sequence[index] || index >= sequence.length) break;
					index++;
					stack.pop();
					sb.append("-\n");
			}

		}

		if (index == sequence.length) {
			System.out.println(sb);
			return;
		}

		System.out.println("NO");

	}
}
