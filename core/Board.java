package sudoku.core;

import java.util.Objects;
import sudoku.io.SimpleBoardWriter;

public class Board {

    private final int[][] values;
    private final boolean[][] isFixed;

    public Board() {
        this.values = new int[9][9];
        this.isFixed = new boolean[9][9];
    }

    public Board(Board board) {
        this();
        Objects.requireNonNull(board);
        for (int y = 0; y < 9; y++) {
            System.arraycopy(board.values[y], 0, values[y], 0, 9);
            System.arraycopy(board.isFixed[y], 0, isFixed[y], 0, 9);
        }
    }

    public int get(int x, int y) {
        checkCoordinates(x, y);
        return values[y][x];
    }

    public boolean isEmpty(int x, int y) {
        return get(x, y) == 0;
    }

    public boolean canSet(int x, int y, int value) {
        checkCoordinates(x, y);
        checkValue(value);

        if (isFixed[y][x]) {
            return false;
        }

        return value == 0 || !columnRowSquareContains(x, y, value);
    }

    public int set(int x, int y, int value) {
        if (canSet(x, y, value)) {
            values[y][x] = value;
        }

        return values[y][x];
    }

    public void clear(int x, int y) {
        set(x, y, 0);
    }

    public boolean isFixed(int x, int y) {
        checkCoordinates(x, y);
        return isFixed[y][x];
    }

    public void fix(int x, int y) {
        checkCoordinates(x, y);
        isFixed[y][x] = true;
    }

    public int getSquare(int x, int y) {
        checkCoordinates(x, y);
        return (y / 3) * 3 + (x / 3);
    }

    private void checkCoordinates(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 0 || x >= 9 || y >= 9) {
            throw new IllegalArgumentException(String.format("Coordinates (%d,%d) out of range", x, y));
        }
    }

    private void checkValue(int value) throws IllegalArgumentException {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Illegal value: " + value);
        }
    }

    private boolean columnRowSquareContains(int x, int y, int value) {
        return columnContains(x, value)
                || rowContains(y, value)
                || squareContains(getSquare(x, y), value);
    }

    protected boolean columnContains(int x, int value) {
        for (int y = 0; y < 9; y++) {
            if (get(x, y) == value) {
                return true;
            }
        }

        return false;
    }

    protected boolean rowContains(int y, int value) {
        for (int x = 0; x < 9; x++) {
            if (get(x, y) == value) {
                return true;
            }
        }

        return false;
    }

    protected boolean squareContains(int square, int value) {
        int x0 = (square % 3) * 3;
        int y0 = (square / 3) * 3;
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                if (get(x0 + dx, y0 + dy) == value) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return new SimpleBoardWriter().write(this);
    }

}
