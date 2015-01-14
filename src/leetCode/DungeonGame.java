package leetCode;

/**
 * Created by gengyu.bi on 2015/1/12.
 */
public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int r = dungeon.length;
		int c = dungeon[0].length;
		int[][] minTotalHurt = new int[r][c];
		int[][] maxDOT = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int damage = dungeon[i][j];
				if (i == 0 && j == 0) {
					minTotalHurt[i][j] = damage;
					maxDOT[i][j] = damage;
				} else if (i == 0) {
					minTotalHurt[i][j] = minTotalHurt[i][j - 1] + damage;
					maxDOT[i][j] = Math.min(maxDOT[i][j - 1], minTotalHurt[i][j]);
				} else if (j == 0) {
					minTotalHurt[i][j] = minTotalHurt[i - 1][j] + damage;
					maxDOT[i][j] = Math.min(maxDOT[i - 1][j], minTotalHurt[i][j]);
				} else {
					int[] totalHurt = new int[2];
					totalHurt[0] = minTotalHurt[i][j - 1] + damage;
					totalHurt[1] = minTotalHurt[i - 1][j] + damage;
					int[] dot = new int[2];
					dot[0] = Math.min(maxDOT[i][j - 1], totalHurt[0]);
					dot[1] = Math.min(maxDOT[i - 1][j], totalHurt[1]);
					minTotalHurt[i][j] = Math.max(totalHurt[0], totalHurt[1]);
					maxDOT[i][j] = Math.max(dot[0], dot[1]);
				}
			}
		}
		int result = maxDOT[r - 1][c - 1];
		if (result > 0)
			return 1;
		else
			return Math.abs(result) + 1;
	}

	public static void main(String[] args) {
		DungeonGame dungeonGame = new DungeonGame();
		int[][] room = new int[][]{{-2}};
		int r = dungeonGame.calculateMinimumHP(room);
		System.out.println(r);
	}
}
