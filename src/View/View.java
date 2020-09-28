package View;

import Model.Tile;

public class View {
    public static void showEmpty(Tile[][] arr) {  // show empty sudoku
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                if (arr[i][j].getValue() == 0) {
                    System.out.print(" " + "0" + " ");
                } else {
                    System.out.print(" " + arr[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void showFilled(Tile[][] arr) { // show filled sudoku
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + arr[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
