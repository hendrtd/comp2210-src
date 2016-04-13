/**
 * GridSearcherClient.java
 * Provides example calls to the GridSearcher
 * bfs and dfs methods.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-03-16
 *
 */
public class GridSearcherClient {

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
      GridSearcher searcher = new GridSearcher(OPEN_GRID);

      int x = 0;
      int y = 0;

      System.out.println("breadthFirst");
      searcher.breadthFirst(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstA");
      searcher.depthFirstA(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstB");
      searcher.depthFirstB(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstC1");
      searcher.depthFirstC1(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstC2");
      searcher.depthFirstC2(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      x = OPEN_GRID.length / 2;
      y = OPEN_GRID[0].length / 2;

      System.out.println("breadthFirst");
      searcher.breadthFirst(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstA");
      searcher.depthFirstA(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstB");
      searcher.depthFirstB(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstC1");
      searcher.depthFirstC1(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstC2");
      searcher.depthFirstC2(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();
    }

}
