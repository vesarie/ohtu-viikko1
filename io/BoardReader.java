package sudoku.io;

import sudoku.core.Board;

public class BoardReader {

    public Board read(String[] board) throws BoardReaderException {
        if (board.length != 9) {
            throw new BoardReaderException("Invalid number of rows: " + board.length);
        }

        Board b = new Board();
        for (int y = 0; y < 9; y++) {
            readRow(b, board[y], y);
        }

        return b;
    }

    private void readRow(Board b, String row, int y) throws BoardReaderException {
        if (row.length() != 9) {
            throw new BoardReaderException("Invalid number of columns: " + row.length());
        }

        for (int x = 0; x < 9; x++) {
            readCharacter(b, row.charAt(x), x, y);
        }
    }

    private void readCharacter(Board b, char c, int x, int y) throws BoardReaderException {
        if (c == ' ') {
            return;
        }

        int value = toInteger(c);
        b.set(x, y, value);
        b.fix(x, y);
    }

    private int toInteger(char c) throws BoardReaderException {
        try {
            int value = Integer.parseInt(c + "");
            if (value < 1 || value > 9) {
                throw new BoardReaderException("Illegal value: " + value);
            }

            return value;
        } catch (NumberFormatException e) {
            throw new BoardReaderException("Invalid symbol", e);
        }
    }

}
