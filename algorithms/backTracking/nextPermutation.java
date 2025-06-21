package backTracking;

public class nextPermutation {
	public static boolean nextPermutation(int[] arr) {
		int i = arr.length - 2;
		while (i >= 0 && arr[i] >= arr[i + 1]) i--;
		if (i < 0) return false;
		int j = arr.length - 1;
		while (arr[j] <= arr[i]) j--;
		// swap arr[i] and arr[j]
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
		// reverse from i+1 to end
		for (int a = i + 1, b = arr.length - 1; a < b; a++, b--) {
			temp = arr[a]; arr[a] = arr[b]; arr[b] = temp;
		}
		return true;
	}

}
