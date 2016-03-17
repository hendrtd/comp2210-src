import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * GridSearcher.java
 * Provides sample implementations of breadth-first and depth-first
 * search in the context of a two-dimensional grid.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-03-15
 *
 */
public class GridSearcher {

   // 2d area to search
   private int[][] grid;

   // visited positions in the search area
   private boolean[][] visited;

   // dimensions of the search area
   private int width;
   private int height;

   // number of neighbors, degrees of motion
   private final int MAX_NEIGHBORS = 8;

   // order in which positions are visited.
   // used to enumerate positions in the grid.
   private int order;

   /**
    * Construct a new GridSearcher object initialized
    * with a default grid.
    */
   public GridSearcher() {
      this(new int[][]{{0,0},{0,0}});
   }

   /**
    * Construct a new GridSearcher object initialized
    * with the given grid specification.
    */
   public GridSearcher(int[][] grd) {
      // initialize grid dimensions
      width = grd.length;
      height = grd[0].length;
      // initialize grid with values in grd
      grid = new int[width][height];
      int x = 0;
      for (int[] row : grd) {
         int y = 0;
         for (int entry : row) {
            grid[x][y] = entry;
            y++;
         }
         x++;
      }
      // initialize visited to false
      markAllUnvisited();
   }

   /**
    * Initializes visited to false.
    */
   public void markAllUnvisited() {
      visited = new boolean[width][height];
      for (boolean[] row : visited) {
         Arrays.fill(row, false);
      }

   }

   /**
    * Fills the current grid with the given value.
    */
   public void fillGrid(int value) {
      for (int x = 0; x < width; x++) {
         for (int y = 0; y < height; y++) {
            grid[x][y] = value;
         }
      }
   }

   /**
    * Returns a string representation of the current grid.
    */
   public String gridToString() {
      StringBuilder sb = new StringBuilder();
      int fieldWidth = 4;
      for (int i = 0; i < fieldWidth * width; i++) {
         sb.append("*");
      }
      sb.append("\n");
      for (int[] row : grid) {
         for (int entry : row) {
            sb.append(String.format("%" + fieldWidth + "d", entry));
         }
         sb.append("\n");
      }
      for (int i = 0; i < fieldWidth * width; i++) {
         sb.append("*");
      }
      sb.append("\n");
      return sb.toString();
   }


   /////////////////////////////////////////////////////////////////////////////////////
   // Breadth-first and depth-first pair; almost identical except for queue v. stack. //
   /////////////////////////////////////////////////////////////////////////////////////

   /**
    * Initializes all to unvisited and launches a breadth-first
    * search in the current grid starting at position (x,y).
    */
   public void breadthFirstQueue(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         bfs(start);
      }
   }

   /**
    * Search the current grid using breadth-first search.
    */
   private void bfs(Position start) {
      Deque<Position> queue = new LinkedList<Position>();
      visit(start);
      process(start);
      queue.addLast(start);
      while (!queue.isEmpty()) {
         Position position = queue.removeFirst();
         for (Position neighbor : position.neighbors()) {
            if (!isVisited(neighbor)) {
               visit(neighbor);
               process(neighbor);
               queue.addLast(neighbor);
            }
         }
      }
   }

   /**
    * Initializes all to unvisited and launches a depth-first
    * search in the current grid starting at position (x,y).
    */
   public void depthFirstStack(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfs(start);
      }
   }

   /**
    * Perform a depth-first traversal on grid starting from
    * the given position. This dfs is iterative and uses a stack.
    */
   private void dfs(Position start) {
      Deque<Position> stack = new LinkedList<Position>();
      visit(start);
      stack.addFirst(start);
      while (!stack.isEmpty()) {
         Position position = stack.removeFirst();
         process(position);
         for (Position neighbor : position.neighbors()) {
            if (!isVisited(neighbor)) {
               visit(neighbor);
               stack.addFirst(neighbor);
            }
         }
      }
   }


   ////////////////////////////////////////////////////////////////////////////////////
   // Depth-first - depth-first pair; one is recursive, one iterative; same ordering //
   ////////////////////////////////////////////////////////////////////////////////////


   /**
    * Initializes all to unvisited and launches a depth-first
    * search in the current grid starting at position (x,y).
    */
   public void depthFirstIterative(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfsi(start);
      }
   }

   // models the global stack implicitly used by the recursive version
   private Deque<Position> stack = new LinkedList<Position>();

   /**
    * Perform a depth-first search/traversal on the current
    * grid starting from the given position. This implementation
    * is iterative and relies on a global stack to maintain
    * the positions on the current depth-first path.
    */
   private void dfsi(Position start) {
      visit(start);
      process(start);
      stack.addFirst(start);
      while (!stack.isEmpty()) {
         Position position = stack.peekFirst();
         Position neighbor = getFirstUnvisited(position.neighbors());
         if (neighbor != null) {
            stack.addFirst(neighbor);
            visit(neighbor);
            process(neighbor);
         }
         else {
            stack.removeFirst();
         }
      }
   }

   /** Returns the first of the given positions that has not been visited. */
   private Position getFirstUnvisited(Position[] positions) {
      for (Position position : positions) {
         if (!isVisited(position)) {
            return position;
         }
      }
      return null;
   }

   /**
    * Initializes all to unvisited and launches a depth-first
    * search in the current grid starting at position (x,y).
    */
   public void depthFirstRecursive(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfsr1(start);
      }
   }

   /**
    * Perform a depth-first traversal on grid starting from
    * the given position.
    */
   private void dfsr1(Position position) {
      visit(position);
      process(position);
      for (Position neighbor : position.neighbors()) {
         if (!isVisited(neighbor)) {
            dfsr1(neighbor);
         }
      }
   }

   /**
    * Initializes all to unvisited and launches a depth-first
    * search in the current grid starting at position (x,y).
    */
   public void depthFirstRecursive2(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfsr2(start);
      }
   }

   /**
    * Perform a depth-first traversal on grid starting from
    * the given position.
    */
   private void dfsr2(Position position) {
      if (isVisited(position)) {
         return;
      }
      visit(position);
      process(position);
      for (Position neighbor : position.neighbors()) {
         dfsr2(neighbor);
      }
   }



   ///////////////////////////////////////////
   // Position class and associated methods //
   ///////////////////////////////////////////

   /**
    * Models an (x,y) position in the grid.
    */
   private class Position {
      int x;
      int y;

      /** Constructs a Position with coordinates (x,y). */
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }

      /** Returns a string representation of this Position. */
      @Override
      public String toString() {
         return "(" + x + ", " + y + ")";
      }

      /** Returns all the neighbors of this Position. */
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBORS];
         int count = 0;
         Position p;
         // generate all eight neighbor positions
         // add to return value if valid
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i == 0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
         return Arrays.copyOf(nbrs, count);
      }
   }

   /**
    * Is this position valid in the search area?
    */
   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < width) && (p.y >= 0) && (p.y < height);
   }

   /**
    * Has this valid position been visited?
    */
   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }

   /**
    * Mark this valid position as having been visited.
    */
   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }

   /**
    * Process this valid position.
    */
   private void process(Position p) {
      grid[p.x][p.y] = order++;
   }

}
