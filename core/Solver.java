package sudoku.core;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private Board board;
    private List<Board> solutions;

    public Board solve(Board b) {
        List<Board> s = solveAll(b);
        if (s.isEmpty()) {
            return null;
        }

        return s.get(0);
    }

    public List<Board> solveAll(Board b) {
        this.board = b;
        this.solutions = new ArrayList<>();

        setValue(0, 0);

        return solutions;
    }

    private void setValue(int x, int y) {
        if (x == 9) {
            setValue(0, y + 1);
            return;
        }
        if (y == 9) {
            solutions.add(new Board(board));
            return;
        }
        if (!board.isEmpty(x, y)) {
            setValue(x + 1, y);
        }

        for (int value = 1; value <= 9; value++) {
            if (board.canSet(x, y, value)) {
                int old = board.get(x, y);

                board.set(x, y, value);
                setValue(x + 1, y);

                board.set(x, y, old);
            }
        }
    }

}
