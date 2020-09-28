package Main;

import Controller.SudokuSolver;
import Model.Board;
import View.View;

public class Main {
    public static void main(String[] args) {
        // test run
//        int[][] board = new int[9][9];
//        String data = "100026039008700601000000200400900516000000000796004008009000000301002900640180003";
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                board[i][j] = data.charAt(9 * i + j) - '0';  // 9 * 1 + 0 and etc
//            }
//        }

        // test random board fill
//        Random rnd = new Random();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                board[i][j] += rnd.nextInt(9);
//            }
//        }

        Board board = new Board(new InputData().getData());
        View.showEmpty(board.getTiles());

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.start();

        //logger.log();
        System.out.println();
        System.out.println("Solved : -------------------------------");
        System.out.println();
        View.showFilled(sudokuSolver.getBoard().getTiles());
    }
}
