package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gengyu.bi on 2015/1/13.
 */
public class SurroundedRegions {
	List<Set<int[]>> pointList = new ArrayList<Set<int[]>>();
	List<Boolean> aliveList = new ArrayList<Boolean>();
	boolean alive = false;

	public void solve(char[][] board) {
		if (board == null || board.length <= 2 || board[0].length <= 2)
			return;
		int r = board.length;
		int c = board[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'O') {
					Set<int[]> pointSet = new HashSet<int[]>();
					bfs(board, i, j, pointSet);
					aliveList.add(alive);
					alive = false;
					pointList.add(pointSet);
				}
			}
		}
		int length = aliveList.size();
		for (int i = 0; i < length; i++) {
			if (aliveList.get(i)) {
				for (int[] point : pointList.get(i)) {
					int x = point[0];
					int y = point[1];
					board[x][y] = 'O';
				}
			} else {
				for (int[] point : pointList.get(i)) {
					int x = point[0];
					int y = point[1];
					board[x][y] = 'X';
				}
			}
		}
	}

	public void bfs(char[][] board, int x, int y, Set<int[]> pointSet) {
		board[x][y] = '.';
		pointSet.add(new int[]{x, y});
		if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) {
			alive = true;
		}
		if (x - 1 >= 0 && board[x - 1][y] == 'O')
			bfs(board, x - 1, y, pointSet);
		if (x + 1 < board.length && board[x + 1][y] == 'O')
			bfs(board, x + 1, y, pointSet);
		if (y - 1 >= 0 && board[x][y - 1] == 'O')
			bfs(board, x, y - 1, pointSet);
		if (y + 1 < board[0].length && board[x][y + 1] == 'O')
			bfs(board, x, y + 1, pointSet);
	}

	public static void main(String[] args) {
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		char[][] board = new char[][]{{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'},
		                              {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
		surroundedRegions.solve(board);
		System.out.println("Surrounded Regions");
	}
}
