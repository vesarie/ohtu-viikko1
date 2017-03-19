package sudoku;

import java.util.List;
import sudoku.core.*;
import sudoku.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class SudokuMain {

    private static Scanner input;
    private static BoardWriter writer;
    private static TreeMap<String, Board> sudokus;

    public static void main(String[] args) throws BoardReaderException {
        sudokus = load();
        input = new Scanner(System.in);
        writer = new NiceBoardWriter();

        String name = getName(args);
        Board board = sudokus.get(name);
        if (board == null) {
            System.out.println("Sudoku not found");
            printNames();
            return;
        }

        play(name, board);
    }

    private static TreeMap<String, Board> load() throws BoardReaderException {
        BoardReader r = new BoardReader();
        TreeMap<String, Board> map = new TreeMap<>();
        map.put("toughestInTheWorld", r.read(Sudokus.toughestInTheWorld));
        map.put("tough", r.read(Sudokus.tough));
        map.put("magazine1", r.read(Sudokus.magazine1));
        map.put("magazine2", r.read(Sudokus.magazine2));
        map.put("easy", r.read(Sudokus.easy));

        return map;
    }

    private static void printNames() {
        System.out.println("Sudokus:");
        for (String name : sudokus.keySet()) {
            System.out.println("    " + name);
        }
    }

    private static String getName(String[] args) {
        if (args.length == 0) {
            printNames();
            System.out.print("Sudoku: ");
            return input.next();
        }

        return args[0];
    }

    private static void play(String name, Board board) {
        System.out.println(writer.write(board));

        Solver solver = new Solver();
        System.out.print("Solving... ");

        long start = System.currentTimeMillis();
        List<Board> solutions = solver.solveAll(board);
        long end = System.currentTimeMillis();

        System.out.format("%d ms\n", end - start);
        printSolutions(solutions);
    }

    private static void printSolutions(List<Board> solutions) {
        if (solutions.isEmpty()) {
            System.out.println("No solution exists");
            return;
        }

        if (solutions.size() == 1) {
            System.out.println(writer.write(solutions.get(0)));
            return;
        }

        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution #" + (i + 1));
            System.out.println(writer.write(solutions.get(i)));
        }
    }

}
