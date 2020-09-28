package Model;

public class Board {
    private Tile[][] tiles;

    public Board(int[][] arr) {
        this.tiles = new Tile[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j] = new Tile(arr[i][j]);
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
