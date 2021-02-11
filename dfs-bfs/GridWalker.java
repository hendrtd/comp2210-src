import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Provides sample implementations of breadth-first and depth-first
 * search in the context of a two-dimensional grid. Reference descriptions
 * of these two search methods are available at:
 *
 * https://en.wikipedia.org/wiki/Depth-first_search
 * https://en.wikipedia.org/wiki/Breadth-first_search
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-06
 *
 */
public class GridWalker {

    // 2d area to traverse
    private int[][] grid;

    // visited positions in the grid
    private boolean[][] visited;

    // dimensions of the grid
    private int numRows;
    private int numCols;

    // number of neighbors, degrees of motion
    private final int MAX_NEIGHBORS = 8;

    // order in which positions are visited.
    // used to enumerate positions in the grid.
    private int order;

    /**
     * Construct a new GridWalker object initialized
     * with a default grid.
     */
    public GridWalker() {
        this(new int[][]{{0,0},{0,0}});
    }

    /**
     * Construct a new GridWalker object initialized
     * with the given grid specification.
     */
    public GridWalker(int[][] grd) {
        // initialize grid dimensions
        numRows = grd.length;
        numCols = grd[0].length;
        // initialize grid with values in grd
        grid = new int[numRows][numCols];
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
        visited = new boolean[numRows][numCols];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

    }

    /**
     * Fills the current grid with the given value.
     */
    public void fillGrid(int value) {
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numCols; y++) {
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
        for (int i = 0; i < fieldWidth * numRows; i++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int[] row : grid) {
            for (int entry : row) {
                sb.append(String.format("%" + fieldWidth + "d", entry));
            }
            sb.append("\n");
        }
        for (int i = 0; i < fieldWidth * numRows; i++) {
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
    public void breadthFirst(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            bfs(start);
        }
    }

    /**
     * Search the current grid using breadth-first search. This algorithm is
     * almost identical to the depth-first search below. The only differences
     * are the use of a queue v. stack and the order in which positions are
     * processed.
     */
    private void bfs(Position start) {
        Deque<Position> queue = new ArrayDeque<>();
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
    public void depthFirstA(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            dfsIterativeA(start);
        }
    }

    /**
     * Perform a depth-first traversal on grid starting from the given
     * position. This algorithm is almost identical to the breadth-first search
     * above. The only differences are the use of a queue v. stack and the
     * order in which positions are processed.
     */
    private void dfsIterativeA(Position start) {
        Deque<Position> stack = new ArrayDeque<>();
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


    //////////////////////////////////////
    // Breadth-first search with memory //
    //////////////////////////////////////

    /**
     * Initializes all to unvisited and launches a breadth-first
     * search in the current grid starting at position (x,y).
     */
    public void breadthFirstMemory(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            bfsMemory(start);
        }
    }

    /**
     * Search the current grid using breadth-first search. This algorithm is
     * identical to the breadth-first search above, except for the addition of
     * memory. Positions are added to the queue wrapped in a node, which is linked
     * to a node containing the position's immediately preceeding neighbor; that is,
     * the neighbor responsible for having this position added to the queue.
     */
    private void bfsMemory(Position start) {
        Deque<Node> queue = new ArrayDeque<>();
        visit(start);
        process(start);
        queue.addLast(new Node(start, null));
        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            Position position = n.position;
            for (Position neighbor : position.neighbors()) {
                if (!isVisited(neighbor)) {
                    visit(neighbor);
                    process(neighbor);
                    queue.addLast(new Node(neighbor, n));
                }
            }
        }
    }


    /**
     * Constructs a node for linking positions together.
     */
    private class Node {
        Position position;
        Node predecessor;

        public Node(Position p, Node pred) {
            position = p;
            predecessor = pred;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    // Depth-first - depth-first pair; one is recursive, one iterative; same ordering //
    ////////////////////////////////////////////////////////////////////////////////////


    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current grid starting at position (x,y).
     */
    public void depthFirstB(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            dfsIterativeB(start);
        }
    }


    /**
     * Perform a depth-first search/traversal on the current grid starting from
     * the given position. This algorithm is the one most closely associated
     * with "depth-first search with backtracking" as used in most writings.
     * This algorithm exhibits exactly the same search ordering as the
     * recursive versions below.
     */
    private void dfsIterativeB(Position start) {
        Deque<Position> stack = new ArrayDeque<>();
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
    public void depthFirstC1(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            dfsRecursive1(start);
        }
    }

    /**
     * Perform a depth-first traversal on grid starting from the given
     * position. This algorithm is the one most closely associated with
     * "depth-first search with backtracking" as used in most writings. This
     * algorithm exhibits exactly the same search ordering as the iterative
     * version above.
     */
    private void dfsRecursive1(Position position) {
        visit(position);
        process(position);
        for (Position neighbor : position.neighbors()) {
            if (!isVisited(neighbor)) {
                dfsRecursive1(neighbor);
            }
        }
    }

    /**
     * Initializes all to unvisited and launches a depth-first
     * search in the current grid starting at position (x,y).
     */
    public void depthFirstC2(int x, int y) {
        markAllUnvisited();
        Position start = new Position(x, y);
        if (isValid(start)) {
            order = 1;
            dfsRecursive2(start);
        }
    }

    /**
     * Perform a depth-first traversal on grid starting from the given
     * position. This algorithm is the one most closely associated with
     * "depth-first search with backtracking" as used in most writings. This
     * algorithm exhibits exactly the same search ordering as the iterative
     * version above.
     */
    private void dfsRecursive2(Position position) {
        if (isVisited(position)) {
            return;
        }
        visit(position);
        process(position);
        for (Position neighbor : position.neighbors()) {
            dfsRecursive2(neighbor);
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
        return (p.x >= 0) && (p.x < numRows) && 
               (p.y >= 0) && (p.y < numCols);
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
