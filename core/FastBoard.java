package sudoku.core;

import java.util.Objects;

public class FastBoard extends Board {

    private boolean[][] columnContains;
    private boolean[][] rowContains;
    private boolean[][] squareContains;

    public FastBoard() {
        super();
        init();
    }

    public FastBoard(Board board) {
        super(Objects.requireNonNull(board));
        init();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                mark(x, y, board.get(x, y));
            }
        }
    }

    public FastBoard(FastBoard board) {
        super(Objects.requireNonNull(board));
        init();
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board.columnContains[i], 0, columnContains[i], 0, 10);
            System.arraycopy(board.rowContains[i], 0, rowContains[i], 0, 10);
            System.arraycopy(board.squareContains[i], 0, squareContains[i], 0, 10);
        }
    }

    private void init() {
        this.columnContains = new boolean[9][10];
        this.rowContains = new boolean[9][10];
        this.squareContains = new boolean[9][10];
    }

    @Override
    public int set(int x, int y, int value) {
        int before = get(x, y);
        int after = super.set(x, y, value);

        if (before != after) {
            erase(x, y, before);
            mark(x, y, after);
        }

        return after;
    }

    private void mark(int x, int y, int value) {
        int square = getSquare(x, y);

        columnContains[x][value] = true;
        rowContains[y][value] = true;
        squareContains[square][value] = true;
    }

    private void erase(int x, int y, int value) {
        int square = getSquare(x, y);

        columnContains[x][value] = false;
        rowContains[y][value] = false;
        squareContains[square][value] = false;
    }

    @Override
    protected boolean columnContains(int x, int value) {
        return columnContains[x][value];
    }

    @Override
    protected boolean rowContains(int y, int value) {
        return rowContains[y][value];
    }

    @Override
    protected boolean squareContains(int square, int value) {
        return squareContains[square][value];
    }

}
