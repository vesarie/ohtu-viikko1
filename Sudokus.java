package sudoku;

public class Sudokus {

    public static final String[] toughestInTheWorld = new String[]{
        "  53     ",
        "8      2 ",
        " 7  1 5  ",
        "4    53  ",
        " 1  7   6",
        "  32   8 ",
        " 6 5    9",
        "  4    3 ",
        "     97  "};

    public static final String[] toughestInTheWorldSolution = new String[]{
        "145327698",
        "839654127",
        "672918543",
        "496185372",
        "218473956",
        "753296481",
        "367542819",
        "984761235",
        "521839764"};

    /**
     * Note: 'tough' has multiple solutions, and the number is very high (>40 000)
     */
    public static final String[] tough = new String[]{
        "         ",
        "     3 85",
        "  1 2    ",
        "   5 7   ",
        "  4   1  ",
        " 9       ",
        "5      7 ",
        "  2 1    ",
        "    4   9"};

    public static final String[] toughSolution = new String[]{
        "237658914",
        "469173285",
        "851924367",
        "123567498",
        "784239156",
        "695481732",
        "546392871",
        "972815643",
        "318746529"};

    public static final String[] magazine1 = new String[]{
        "  8     2",
        "3 1     6",
        "6 4  21 9",
        " 19  8   ",
        "26 9  5  ",
        "    3 6 7",
        "8 7 239  ",
        "1 2 863  ",
        "5  7     "};

    public static final String[] magazine2 = new String[]{
        "   97 3 5",
        "24   5   ",
        "      6  ",
        "  9 1  3 ",
        "  5 68  9",
        " 1      6",
        " 82    9 ",
        " 7     1 ",
        "      4  "};

    public static final String[] easy = new String[]{
        "8  93   2",
        "  9    4 ",
        "7 21  96 ",
        "2      9 ",
        " 6     7 ",
        " 7   6  5",
        " 27  84 6",
        " 3    5  ",
        "5   62  8"};

    public static final String[] easySolution = new String[]{
        "846937152",
        "319625847",
        "752184963",
        "285713694",
        "463859271",
        "971246385",
        "127598436",
        "638471529",
        "594362718"};

}
