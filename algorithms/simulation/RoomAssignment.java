package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RoomAssignment {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄: 학생 수 N, 한 방에 배정할 수 있는 최대 인원 K 입력
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		// 학생 정보 입력 (성별, 학년)
		int[][] students = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] info = br.readLine().split(" ");
			students[i][0] = Integer.parseInt(info[0]); // 성별 (0:여, 1:남)
			students[i][1] = Integer.parseInt(info[1]); // 학년 (1~6)
		}

		assignment(n, k, students);
	}

	private static void assignment(int n, int k, int[][] students) {
		int room = 0;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int gender = students[i][0];
			int grade = students[i][1];

			String key = gender + "" + grade;
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			room += (val + k - 1) / k;
		}

		System.out.println(room);
	}
}
