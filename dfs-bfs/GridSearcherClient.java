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

      System.out.println("breadthFirstQueue");
      searcher.breadthFirstQueue(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstStack");
      searcher.depthFirstStack(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstRecursive");
      searcher.depthFirstRecursive(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstIterative");
      searcher.depthFirstIterative(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();

      System.out.println("depthFirstRecursive2");
      searcher.depthFirstRecursive2(x, y);
      System.out.println(searcher.gridToString());
      System.out.println();
   }


   /*
      GridSearcher searcher = new GridSearcher(OPEN_GRID);
      System.out.println("Breadth-first Search\n");
      // searcher.printGrid();
      searcher.breadth_first(3, 2);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.breadth_first(0, 0);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.breadth_first(5, 4);
      searcher.printGrid();
      System.out.println();

      System.out.println("Iterative Depth-first Search\n");
      searcher.fillGrid(0);
      // searcher.printGrid();
      searcher.depth_first_stack(3, 2);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_stack(0, 0);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_stack(5, 4);
      searcher.printGrid();
      System.out.println();

      System.out.println("Iterative Depth-first Search Global Stack\n");
      searcher.fillGrid(0);
      // searcher.printGrid();
      searcher.depth_first_stack_global(3, 2);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_stack_global(0, 0);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_stack_global(5, 4);
      searcher.printGrid();
      System.out.println();

      System.out.println("Recursive Depth-first Search\n");
      searcher.fillGrid(0);
      // searcher.printGrid();
      searcher.depth_first_recursive(3, 2);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_recursive(0, 0);
      searcher.printGrid();
      System.out.println();
      searcher.fillGrid(0);
      searcher.depth_first_recursive(5, 4);
      searcher.printGrid();
      System.out.println();

      System.out.println("\u2425");
   */

}
