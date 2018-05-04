package random.programs;

public class LeetCodeBestScore798 {
	public static void main(String[] args) {
		System.out.println(new LeetCodeBestScore798().bestRotation(new int[] {}));
	}

	public int bestRotation(int[] A) {
		int bestRotate = 0;
		int bestScore = 0;
		for (int i = 0; i < A.length; i++) {
			int score = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[(j + i) % A.length] <= j)
					score++;
			}
			if (score > bestScore) {
				bestScore = score;
				bestRotate = i;
			}
		}
		return bestRotate;

	}
}
