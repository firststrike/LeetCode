package leetCode;

public class myCode {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		WordSearch wordSearch = new WordSearch();
		print(wordSearch.exist(board, "SECCS"));
	}

	private static String removeBlock(String input) {
		input = input.replace("[", "");
		input = input.replace("]", "");
		input = input.replace("{", "");
		input = input.replace("}", "");
		return input;
	}

	public static void print(Object input) {
		System.out.println(input);
	}
}
