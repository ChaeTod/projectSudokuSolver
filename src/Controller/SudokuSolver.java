package Controller;

import Main.InputData;
import Model.Board;
import Model.Tile;

public class SudokuSolver {
    private int[][] arr;
    private Board board;

    public void start() {  // start solving the sudoku
        if (!readData()) {
            System.out.println("Wrong data source");
            return;
        }
        board = new Board(arr);
        solveSudoku(getBoard().getTiles());
    }

    public Board getBoard() {
        return board;
    }

    public boolean readData() {
        arr = new InputData().getData();
        return true;
    }

    public boolean solveSudoku(Tile[][] board) {
        int x = -1;  // start coordinates from -1 to control sudoku solving status. When we won't have any rows to go - sudoku solved = exit.
        int y = -1;

        for (int row = 0; row < board.length; row++) {  // get the incoming coordinates where to go
            for (int col = 0; col < board.length; col++) {
                if (board[row][col].getValue() == 0) {
                    x = row;
                    y = col;
                }
            }
        }

        if (x == -1) { // if we started from the begging again - sudoku solved. This is an exit point from this recursion.
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isAvailable(board, x, y, num)) {
                board[x][y].setValue(num);
                if (solveSudoku(board)) { // start the recursion here
                    return true;
                }
                board[x][y].setValue(0);
            }
        }
        return false;
    }

    // What's the problem, Artem? Don't have enough 'brainzz' to solve this? The burning you feel - it is shame! Try harder! Still, you have free time to writing this nonsense, huh?

    public boolean isAvailable(Tile[][] board, int row, int col, int num) {

        int count = 0;
        if (findAvailableInRow(board, row, num))
            return false;
        else if (findAvailableInCol(board, col, num))
            return false;
        else return !findAvailableInSquare(board, row - row % 3, col - col % 3, num);
    }

    public boolean findAvailableInRow(Tile[][] board, int row, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i].getValue() == num) {
                return true;
            }
        }
        return false;
    }

    public boolean findAvailableInCol(Tile[][] board, int col, int num) {
        for (Tile[] tiles : board) {
            if (tiles[col].getValue() == num) {
                return true;
            }
        }
        return false;
    }

    public boolean findAvailableInSquare(Tile[][] board, int firstRow, int firstCol, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (board[row + firstRow][col + firstCol].getValue() == num) {
                    return true;
                }
        return false;
    }
}
