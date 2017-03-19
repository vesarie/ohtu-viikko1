package sudoku.io;

import sudoku.core.Board;

public class NiceBoardWriter implements BoardWriter {

    @Override
    public String write(Board board) {
        StringBuilder str = new StringBuilder();
        for (int y = 0; y < 9; y++) {
            if (y % 3 == 0) {
                str.append("+---+---+---+\n");
            }

            for (int x = 0; x < 9; x++) {
                if (x % 3 == 0) {
                    str.append("|");
                }

                if (board.isEmpty(x, y)) {
                    str.append(" ");
                } else {
                    str.append(board.get(x, y));
                }
            }

            str.append("|\n");
        }

        str.append("+---+---+---+");
        return str.toString();
    }

}
