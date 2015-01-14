package leetCode;

import java.util.Date;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		Date date = new Date();
		long start = date.getTime();
		Board sodokuBoard = new Board();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				int value = board[r][c] - '0';
				if (value > 0) {
					sodokuBoard.set(r, c, value);
				}
			}
		}
		sodokuBoard.print();

		int setCount = sodokuBoard.getSetCount();
		while (!sodokuBoard.isOk() && sodokuBoard.checkBoard()) {
			sodokuBoard.setBoard();
			if (sodokuBoard.getSetCount() == setCount) {
				System.out.println("guess!");
				if (sodokuBoard.guess()) {
				}
			} else {
				setCount = sodokuBoard.getSetCount();
			}
		}
		if (sodokuBoard.isOk()) {
			date = new Date();
			long end = date.getTime();
			System.out.println("解完！耗时：" + (end - start) + "毫秒");
		} else {
			System.out.println("无解！");
		}
		// sodokuBoard.print();
	}
}

class Board {
	private int[] rowSurplus;
	private int[] colSurplus;
	private int[] boxSurplus;
	private Cell[][] cells;
	private int setCount;

	public Board() {
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		setCount = 0;
		rowSurplus = new int[9];
		colSurplus = new int[9];
		boxSurplus = new int[9];
		for (int i = 0; i < 9; i++) {
			this.rowSurplus[i] = 1;
			this.colSurplus[i] = 1;
			this.boxSurplus[i] = 1;
		}
		cells = new Cell[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				cells[r][c] = new Cell();
			}
		}
	}

	public boolean setBoard() {
		if (checkBoard()) {
			setUnique();
			for (int i = 0; i < 9; i++) {
				for (int value = 1; value <= 9; value++) {
					setRow(i, value);
					setCol(i, value);
					setBox(i, value);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 为某个格子填值
	 * 
	 * @param r
	 * @param c
	 * @param value
	 */
	public boolean set(int r, int c, int value) {
		if (checkValue(r, c, value)) {
			removeRow(r, c, value);
			removeCol(r, c, value);
			removeBox(r, c, value);
			this.cells[r][c].set(value);
			this.setCount++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 遍历board，为只剩一个候选值的格子填值
	 * 
	 * @return
	 */
	public boolean setUnique() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (cells[r][c].getSurplus() == 1) {
					int value = cells[r][c].getUnique();
					if (value > 0) {
						set(r, c, value);
					}
				}
			}
		}
		print();
		return true;
	}

	/**
	 * 对于给定的值value和格子(r,c)，去除同一行其他格子的value候选
	 * 
	 * @param r
	 * @param value
	 */
	public void removeRow(int r, int c, int value) {
		for (int i = 0; i < 9; i++) {
			if (i != c) {
				this.cells[r][i].remove(value);
			}
		}
	}

	/**
	 * 对于给定的值value和格子(r,c)，去除同一列其他格子的value候选
	 * 
	 * @param c
	 * @param value
	 */
	public void removeCol(int r, int c, int value) {
		for (int i = 0; i < 9; i++) {
			if (i != r) {
				this.cells[i][c].remove(value);
			}
		}
	}

	/**
	 * 对于给定的值value和格子(r,c)，去除所在九宫格其他格子的value候选
	 * 
	 * @param r
	 * @param c
	 * @param value
	 */
	public void removeBox(int r, int c, int value) {
		int r0 = (r / 3) * 3;
		int c0 = (c / 3) * 3;
		for (int i = r0; i < r0 + 3; i++) {
			for (int j = c0; j < c0 + 3; j++) {
				if (i != r && j != c) {
					this.cells[i][j].remove(value);
				}
			}
		}
	}

	/**
	 * 对于给定行r和值value，如果value只有唯一候选位，填值
	 * 
	 * @param r
	 * @param value
	 */
	public void setRow(int r, int value) {
		if (checkRow(r, value)) {
			int index = -1;
			int count = 0;
			for (int c = 0; c < 9; c++) {
				if (cells[r][c].getNumber()[value - 1] > 0) {
					index = c;
					count++;
				}
			}
			if (count == 1) {
				set(r, index, value);
			}
		}
	}

	/**
	 * 对于给定列c和值value，如果value只有唯一候选位，填值
	 * 
	 * @param c
	 * @param value
	 */
	public void setCol(int c, int value) {
		if (checkCol(c, value)) {
			int index = -1;
			int count = 0;
			for (int r = 0; r < 9; r++) {
				if (cells[r][c].getNumber()[value - 1] > 0) {
					index = r;
					count++;
				}
			}
			if (count == 1) {
				set(index, c, value);
			}
		}
	}

	/**
	 * 对于给定九宫格b和值value，如果value只有唯一候选位，填值
	 * 
	 * @param b
	 * @param value
	 */
	public void setBox(int b, int value) {
		int r0 = b / 3;
		int c0 = b % 3;
		if (checkBox(r0 * 3, c0 * 3, value)) {
			int index_r = -1;
			int index_c = -1;
			int count = 0;
			for (int r = r0 * 3; r < r0 * 3 + 3; r++) {
				for (int c = c0 * 3; c < c0 * 3 + 3; c++) {
					if (cells[r][c].getNumber()[value - 1] > 0) {
						index_r = r;
						index_c = c;
						count++;
					}
				}
			}
			if (count == 1) {
				set(index_r, index_c, value);
			}
		}
	}

	/**
	 * 对于给定的格子(r,c)，如果其所在行r，列c和九宫格上均无value，返回true
	 * 
	 * @param r
	 * @param c
	 * @param value
	 * @return
	 */
	public boolean checkValue(int r, int c, int value) {
		if (checkRow(r, value) && checkCol(c, value) && checkBox(r, c, value)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 给定行r和值value，如果r上已有value，返回false
	 * 
	 * @param r
	 * @param value
	 */
	public boolean checkRow(int r, int value) {
		for (int i = 0; i < 9; i++) {
			if (this.cells[r][i].getValue() == value) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 给定列c和值value，如果c上已有value，返回false
	 * 
	 * @param c
	 * @param value
	 */
	public boolean checkCol(int c, int value) {
		for (int i = 0; i < 9; i++) {
			if (this.cells[i][c].getValue() == value) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 给定格子(r,c)和值value，如果(r,c)所在九宫格上已有value，返回false
	 * 
	 * @param i
	 *            0-9
	 * @param j
	 *            0-9
	 * @param value
	 */
	public boolean checkBox(int r, int c, int value) {
		for (int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
			for (int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
				if (this.cells[i][j].getValue() == value) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 遍历盘面所有格子，如果有一个格子没有值可填，返回false
	 * 
	 * @return
	 */
	public boolean checkBoard() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				int count = 0;
				for (int value = 1; value <= 9; value++) {
					if (cells[r][c].getNumber()[value - 1] > 0) {
						count++;
						break;
					}
				}
				if (count == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isOk() {
		if (this.getSetCount() == 81) {
			print();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 猜值
	 * 
	 * @return
	 */
	public boolean guess() {
		GuessValue guessValue = new GuessValue(this);
		int index = guessValue.getArternateValues();
		if (index < 0) {
			return false;
		} else {
			set(guessValue.getR(), guessValue.getC(),
					guessValue.getValues()[index]);
			return true;
		}
	}

	/**
	 * 打印结果
	 */
	public void print() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				int value = cells[r][c].getValue();
				if (value > 0) {
					System.out.print(value);
				} else {
					System.out.print(".");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

}

class GuessValue {
	private Board[] tempBoards;
	private Board sokudoBoard;
	private int[] values;
	private int[] guessResult;
	private int setCount;
	private int r;
	private int c;

	public GuessValue(Board board) {
		init(board);
		this.sokudoBoard = board;
	}

	private void init(Board board) {
		this.r = -1;
		this.c = -1;
		this.values = new int[2];
		this.tempBoards = new Board[2];
		this.guessResult = new int[2];
		for (int i = 0; i < 2; i++) {
			tempBoards[i] = new Board();
			guessResult[i] = -1;
			values[i] = -1;
		}
		this.setCount = board.getSetCount();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				tempBoards[0].set(r, c, board.getCells()[r][c].getValue());
				tempBoards[1].set(r, c, board.getCells()[r][c].getValue());
			}
		}
	}

	public int doGuess(int r, int c, int[] values) {
		tempBoards[0].set(this.r, this.c, values[0]);
		this.setCount = tempBoards[0].getSetCount();
		do {
			tempBoards[0].setBoard();
			if (this.setCount == tempBoards[0].getSetCount()) {
				guessResult[0] = 0;
				if (tempBoards[0].isOk()) {
					guessResult[0] = 1;
				}
				break;
			} else {
				this.setCount = tempBoards[0].getSetCount();
			}
		} while (tempBoards[0].checkBoard());
		tempBoards[1].set(this.r, this.c, values[1]);
		this.setCount = tempBoards[1].getSetCount();
		do {
			tempBoards[1].setBoard();
			if (this.setCount == tempBoards[1].getSetCount()) {
				guessResult[1] = 0;
				if (tempBoards[1].isOk()) {
					guessResult[1] = 1;
				}
				break;
			} else {
				this.setCount = tempBoards[1].getSetCount();
			}
		} while (tempBoards[1].checkBoard());
		if (guessResult[0] == 1 || guessResult[1] == 1) {
			if (guessResult[0] == 1) {
				System.out.println(this.r + "," + this.c + ",value="
						+ values[0]);
				return 0;
			} else {
				System.out.println(this.r + "," + this.c + ",value="
						+ values[1]);
				return 1;
			}
		} else if (guessResult[0] == -1 || guessResult[1] == -1) {
			if (guessResult[0] == -1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	/**
	 * 寻找只有两个候选值的单元格
	 * 
	 * @return
	 */
	public int getArternateValues() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (tempBoards[0].getCells()[r][c].getSurplus() == 2
						&& this.values[1] <= 0) {
					this.r = r;
					this.c = c;
					for (int i = 0; i < 9; i++) {
						if (tempBoards[0].getCells()[r][c].getNumber()[i] > 0) {
							if (this.values[0] <= 0) {
								this.values[0] = i + 1;
							} else {
								this.values[1] = i + 1;
							}
						}
					}
					int index = doGuess(r, c, this.values);
					if (index >= 0) {
						return index;
					} else {
						init(this.sokudoBoard);
						continue;
					}
				}
			}
		}
		return -1;
	}

	public Board[] getTempBoards() {
		return tempBoards;
	}

	public void setTempBoards(Board[] tempBoards) {
		this.tempBoards = tempBoards;
	}

	public int[] getGuessResult() {
		return guessResult;
	}

	public void setGuessResult(int[] guessResult) {
		this.guessResult = guessResult;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public int[] getValues() {
		return values;
	}

}

class Cell {
	private int surplus;
	private int value;
	private int[] number = new int[9];

	public Cell() {
		this.surplus = 9;
		this.value = -1;
		for (int i = 0; i < number.length; i++) {
			number[i] = 1;
		}
	}

	/**
	 * 确定值
	 * 
	 * @param c
	 */
	public void set(int value) {
		if (this.value < 0 && (value >= 1 && value <= 9)) {
			this.value = value;
			this.surplus = 1;
			for (int i = 0; i < 9; i++) {
				number[i] = 0;
			}
			number[value - 1] = 1;
		}
	}

	/**
	 * 去掉一个候选值
	 * 
	 * @param c
	 */
	public boolean remove(int value) {
		if (this.value < 0 && (value >= 1 && value <= 9)) {
			if (this.number[value - 1] > 0) {
				this.number[value - 1] = 0;
				this.surplus--;
				// if (this.surplus == 1) {
				// for (int i = 0; i < 9; i++) {
				// if (this.number[i] > 0) {
				// set(i + 1);
				// return true;
				// }
				// }
				// return false;
				// }
				if (this.surplus == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 获取剩余唯一值
	 * 
	 * @return
	 */
	public int getUnique() {
		if (this.surplus > 1) {
			return -1;
		} else {
			for (int i = 0; i < 9; i++) {
				if (this.number[i] > 0) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	public int getSurplus() {
		return surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int[] getNumber() {
		return number;
	}

	public void setNumber(int[] number) {
		this.number = number;
	}

}
