package DFS;

public class Network {

	public static void main(String[] args) {
		int[][] computers = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(3, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] visited = new boolean[n];

		for (int i = 0; i < computers.length; i++) {
			if (!visited[i]) {
				answer++;
				dfs(computers, visited, i);
			}
		}

		return answer;
	}

	public static void dfs(int[][] computers, boolean[] visited, int index) {
		visited[index] = true;

		for (int i = 0; i < computers[index].length; i++) {
			if (!visited[i] && computers[index][i] == 1) {
				dfs(computers, visited, i);
			}
		}
	}



}
