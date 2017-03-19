package sudoku.io;

import sudoku.core.Board;

public class SimpleBoardWriter implements BoardWriter {

    @Override
    public String write(Board board) {
        StringBuilder str = new StringBuilder();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.isEmpty(x, y)) {
                    str.append(" ");
                } else {
                    str.append(board.get(x, y));
                }
            }

            if (y + 1 < 9) {
                str.append("\n");
            }
        }

        return str.toString();
    }

}
