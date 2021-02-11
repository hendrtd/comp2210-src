/**
 * Provides example calls to the GridWalker
 * bfs and dfs methods.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-03-16
 *
 */
public class GridWalkerClient {

    private static final int[][] OPEN_GRID =
                     {
                      {0, 0, 0, 0, 0,},
                      {0, 0, 0, 0, 0,},
                      {0, 0, 0, 0, 0,},
                      {0, 0, 0, 0, 0,},
                      {0, 0, 0, 0, 0,},
                      {0, 0, 0, 0, 0,},
                     };

    /**
     * Drives execution.
     */
    public static void main(String[] args) {
        GridWalker searcher = new GridWalker(OPEN_GRID);

        System.out.println("/////////////////////////////////////////////");

        int x = 0;
        int y = 0;

        // x = OPEN_GRID.length / 2;
        // y = OPEN_GRID[0].length / 2;

        System.out.println("breadthFirst from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.breadthFirst(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

        System.out.println("breadthFirstMemory from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.breadthFirstMemory(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

        System.out.println("depthFirstA from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.depthFirstA(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

        System.out.println("depthFirstB from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.depthFirstB(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

        System.out.println("depthFirstC1 from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.depthFirstC1(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

        System.out.println("depthFirstC2 from " + "(" + x + ", " + y + ")");
        searcher.fillGrid(0);
        searcher.depthFirstC2(x, y);
        System.out.println(searcher.gridToString());
        System.out.println();

     }

}
