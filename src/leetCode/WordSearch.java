package leetCode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.equals("") || board == null) {
			return false;
		}
		char[] charArray = word.toCharArray();
		int[][] searched = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (charArray[0] == board[i][j]) {
					if (charArray.length == 1) {
						return true;
					} else {
						boolean result = matching(i, j, board, charArray, 0,
								searched);
						if (result) {
							return true;
						} else {
							continue;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean matching(int i, int j, char[][] board, char[] words,
			int index, int[][] searched) {
		if (index >= words.length) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if (searched[i][j] == 1) {
			return false;
		}
		char c = words[index];
		if (board[i][j] != c) {
			return false;
		} else {
			searched[i][j] = 1;
			boolean result = matching(i - 1, j, board, words, index + 1,
					searched)
					|| matching(i + 1, j, board, words, index + 1, searched)
					|| matching(i, j - 1, board, words, index + 1, searched)
					|| matching(i, j + 1, board, words, index + 1, searched);
			if (!result) {
				searched[i][j] = 0;
			}
			return result;
		}
	}
}
